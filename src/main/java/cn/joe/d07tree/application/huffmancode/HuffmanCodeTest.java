package cn.joe.d07tree.application.huffmancode;

import org.junit.Before;
import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Joe
 * @create 2020/4/16 20:36
 */
public class HuffmanCodeTest {
    HuffmanCode huffmanCode;
    Node root;
    List<Node> nodes;
    byte[] contentBytes;
    String str;

    @Before
    public void before() {
        str = "i like like like java do you like a java";
        contentBytes = str.getBytes();
        // 40
        // System.out.println("contentBytes.length = " + contentBytes.length);
        huffmanCode = new HuffmanCode();
        nodes = huffmanCode.getNodes(contentBytes);
        root = huffmanCode.createHuffmanTree(nodes);
    }

    @Test
    public void testCreateTree() {
        Map<Byte, String> huffmanCodeCodes = huffmanCode.getCodes(root);

        byte[] zip = huffmanCode.zip(contentBytes, huffmanCodeCodes);
        System.out.println("zip = " + Arrays.toString(zip));
        byte[] sourceByte = huffmanCode.decode(huffmanCodeCodes, zip);
        System.out.println("sourceByte = " + new String(sourceByte));
    }

    @Test
    public void testHuffmanZip() {

        byte[] bytes = huffmanCode.huffmanZip(str);
        System.out.println("bytes = " + Arrays.toString(bytes));

    }

    @Test
    public void testZipFile() {

        String srcFile = "D:\\BaiduNetdiskDownload\\尚硅谷Java学科全套教程\\1.尚硅谷全套JAVA教程--基础阶段\\14. 尚硅谷Java数据结构和算法\\资料\\压缩测试文件\\src.bmp";
        String dstFile = "D:\\dst.zip";
        huffmanCode.zipFile(srcFile,dstFile);
        System.out.println("success");

    }

    @Test
    public void testUnZipFile(){
        String zipFile = "D:\\dst.zip";
        String dstFile = "D:\\dst.png";
        huffmanCode.unZipFile(zipFile,dstFile);
        System.out.println("hello");
    }
}
