package com.joe.old.d07tree;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Joe
 * @create 2020/4/15 16:25
 */
public class BinaryTreeTest {
    BinaryTree binaryTree;

    @Before
    public void before() {
        binaryTree = new BinaryTree();
        BinaryTree.Node root = new BinaryTree.Node(1, 1);
        BinaryTree.Node node2 = new BinaryTree.Node(2, 2);
        BinaryTree.Node node3 = new BinaryTree.Node(3, 3);
        BinaryTree.Node node4 = new BinaryTree.Node(4, 4);
        BinaryTree.Node node5 = new BinaryTree.Node(5, 5);

        // 先手动创建二叉树, 后面递归创建
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
    }

    @Test
    public void testRemove(){
        System.out.println("before remove");
        binaryTree.preOrder();

        binaryTree.removeByRule1(3);
        System.out.println(" after remove");
        binaryTree.preOrder();
    }

    @Test
    public void testSearch() {
        System.out.println("pre search");
        BinaryTree.Node result1 = binaryTree.preOrderSearch(5);
        System.out.println("result1 = " + result1);

        System.out.println("infix search");
        BinaryTree.Node result2 = binaryTree.infixOrderSearch(5);
        System.out.println("result2 = " + result2);

        System.out.println("post search");
        BinaryTree.Node result3 = binaryTree.postOrderSearch(5);
        System.out.println("result3 = " + result3);

    }

    @Test
    public void testOrder() {


        System.out.println("pre order");
        binaryTree.preOrder();
        System.out.println("infix order");
        binaryTree.infixOrder();
        System.out.println("post order");
        binaryTree.postOrder();
    }

}
