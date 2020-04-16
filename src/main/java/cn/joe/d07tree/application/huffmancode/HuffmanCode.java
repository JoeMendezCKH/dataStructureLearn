package cn.joe.d07tree.application.huffmancode;


import java.util.*;

/**
 * @author Joe
 * @create 2020/4/16 20:02
 */
public class HuffmanCode {

    private Map<Byte, String> huffmanCodes = new HashMap<>(16);


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
