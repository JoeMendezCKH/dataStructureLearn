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

    }
}
