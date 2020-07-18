package com.joe.old.d07tree.application.huffmancode;


import java.io.*;
import java.util.*;

/**
 * @author Joe
 * @create 2020/4/16 20:02
 */
public class HuffmanCode {

    private Map<Byte, String> huffmanCodes = new HashMap<>(16);

    /**
     * @param srcFile source file path
     * @param dstFile target zip file path
     */
    @SuppressWarnings({"unused", "ResultOfMethodCallIgnored"})
    public void zipFile(String srcFile, String dstFile) {
        try (
                FileInputStream fileInputStream = new FileInputStream(srcFile);
                OutputStream outputStream = new FileOutputStream(dstFile);
                ObjectOutputStream oos = new ObjectOutputStream(outputStream)
        ) {
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);

            // 对文件压缩
            byte[] huffmanZip = huffmanZip(bytes);
            // 以对象流的方式写出, 方便恢复源文件
            oos.writeObject(huffmanZip);
            // 要把哈夫曼编码表写出, 否则无法恢复
            oos.writeObject(huffmanCodes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param zipFile 准备解压的文件
     * @param dstFile 解压路径
     */
    public void unZipFile(String zipFile, String dstFile) {
        try (
                InputStream inputStream = new FileInputStream(zipFile);
                ObjectInputStream ois = new ObjectInputStream(inputStream);
                OutputStream os = new FileOutputStream(dstFile);
        ) {
            byte[] huffmanByte = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCode = (Map<Byte, String>) ois.readObject();
            byte[] bytes = decode(huffmanCode,huffmanByte);
            os.write(bytes);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }


    /**
     * @param bytes 原始的字节数组
     * @return 经过哈夫曼编码后的字节数组
     */

    public byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
        return zip(bytes, codes);
    }

    public byte[] huffmanZip(String string) {
        byte[] bytes = string.getBytes();
        return this.huffmanZip(bytes);
    }

    /**
     * decode
     *
     * @param huffmanCodes 哈夫曼编码表
     * @param huffmanBytes 哈夫曼编码得到的字节数组
     * @return 原始数组
     */
    public byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i == (huffmanBytes.length - 1));
            stringBuilder.append(byteToBitString(huffmanBytes[i], !flag));
        }
        Map<String, Byte> map = new HashMap<>(16);
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            // 小的计数器
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                // get one bit '0'or'1';  i is stop
                // just move count until find key in the map
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    /**
     * change a byte to binary String
     *
     * @param b    source byte
     * @param flag 是否需要补高位, true 需要, 最后一个不需要补高位
     * @return result string (补码返回)
     */
    public String byteToBitString(byte b, boolean flag) {
        int temp = b;
        if (flag) {
            // 1 0000 0000 | temp 补高位
            temp |= 256;
        }
        // 返回的是补码,正数的补码就是自己 int类型是4个字节, 也就是 32位,
        // 但是之前写的 Huffman code 是按8位编码的, 所以只取低8位
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    /**
     * 将哈夫曼编码表 放在map<Byte, String>中, 形如 32 = 001
     * 得到 node 节点所有叶子节点的哈夫曼编码, 放入到 HuffmanCodes集合中
     *
     * @param node          root node
     * @param code          路径, left is 0, right is 1
     * @param stringBuilder 拼接路径
     */
    public void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            // 非 叶子节点
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    public Map<Byte, String> getCodes(Node node) {
        if (node != null) {
            StringBuilder builder = new StringBuilder();
            this.getCodes(node, "", builder);
            return huffmanCodes;
        } else {
            throw new RuntimeException("empty tree");
        }
    }


    /**
     * 将字节数组转换为带权值的列表
     *
     * @param bytes 字节数组
     * @return 带权值的列表
     */
    public List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        HashMap<Byte, Integer> counts = new HashMap<>(16);
        for (byte b : bytes) {
            counts.merge(b, 1, Integer::sum);
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    public void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
            System.out.println();
        } else {
            System.out.println("empty tree");
        }
    }

    /**
     * 根据列表创建 Huffman tree
     *
     * @param nodes 列表
     * @return tree
     */
    public Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * @param bytes        原始字符数组
     * @param huffmanCodes 生成的 huffman code
     * @return 哈夫曼编码后重新生成的byte[]
     */
    public byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        // 将生成的哈夫曼编码结果放入 stringBuilder 中
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        /*int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        }else {
            len = stringBuilder.length() / 8 +1;
        }*/

        int len = (stringBuilder.length() + 7) / 8;
        // 反编码
        byte[] temp = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            temp[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return temp;
    }


}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public void preOrder() {
        System.out.print(this + " --> ");
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return " " + data + ": " + weight;
    }
}
