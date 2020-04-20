package cn.joe.d07tree.application.binarysorttree;

import org.junit.Test;

/**
 * @author Joe
 * @create 2020/4/18 9:40
 */
public class BinarySortTreeTest {
    @Test
    public void test1() {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.put(new BinarySortTree.Node(i));
        }

        // 1 --> 3 --> 5 --> 7 --> 9 --> 10 --> 12
        binarySortTree.infixOrder();

        binarySortTree.remove(7);
        binarySortTree.infixOrder();
    }
}
