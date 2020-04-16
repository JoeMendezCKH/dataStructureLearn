package cn.joe.d07tree.application.huffman;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Joe
 * @create 2020/4/16 17:16
 */
public class HuffmanTreeTest {
    HuffmanTree huffmanTree = new HuffmanTree();
    int[] arr;

    @Before
    public void before() {
        arr = new int[]{13, 7, 8, 3, 29, 6, 1};
    }

    @Test
    public void testCreateHuffman() {
        HuffmanTree.Node root = this.huffmanTree.createHuffmanTree(arr);
        huffmanTree.preOrder(root);

    }
}
