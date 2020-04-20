package cn.joe.d07tree.application.avltree;

import org.junit.Test;

/**
 * @author Joe
 * @create 2020/4/20 8:58
 */
public class AvlTreeTest {

    AvlTree avlTree;

    public void init(int[] arr) {
        avlTree = new AvlTree();
        for (int i : arr) {
            avlTree.put(new AvlTree.Node(i));
        }
    }

    @Test
    public void testLeftRotate() {
        int[] arr = {4, 3, 6, 5, 7, 8};
        init(arr);

        avlTree.infixOrder();

        System.out.println("左旋");
        // 4-->3
        System.out.println(avlTree.getRoot().height());
        // 1-->2
        System.out.println(avlTree.getRoot().leftHeight());
        // 3-->2
        System.out.println(avlTree.getRoot().rightHeight());
    }

    @Test
    public void testRightRotate() {
        int[] arr = {10, 12, 8, 9, 7, 6};
        init(arr);
        avlTree.infixOrder();
        System.out.println("右旋");
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
        System.out.println(avlTree.getRoot());
    }

    @Test
    public void testDoubleRotate() {
        int[] arr = {10, 11, 7, 6, 8, 9};
        init(arr);
        avlTree.infixOrder();
        System.out.println("双旋");
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
        System.out.println(avlTree.getRoot());
    }

}
