package cn.joe.d07tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Joe
 * @create 2020/4/16 9:16
 */
public class ThreadedBinaryTreeTest {
    ThreadedBinaryTree threadedBinaryTree;
    ThreadedBinaryTree.Node root;
    ThreadedBinaryTree.Node node2;
    ThreadedBinaryTree.Node node3;
    ThreadedBinaryTree.Node node4;
    ThreadedBinaryTree.Node node5;
    ThreadedBinaryTree.Node node6;

    @Before
    public void before() {
        root = new ThreadedBinaryTree.Node(1, 1);
        node2 = new ThreadedBinaryTree.Node(3, 1);
        node3 = new ThreadedBinaryTree.Node(6, 1);
        node4 = new ThreadedBinaryTree.Node(8, 1);
        node5 = new ThreadedBinaryTree.Node(10, 1);
        node6 = new ThreadedBinaryTree.Node(14, 1);
        // 手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node2.setParent(root);
        node3.setParent(root);
        node4.setParent(node2);
        node5.setParent(node2);
        node6.setParent(node3);

        threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
    }

    @Test
    public void testThreadedPreOrder(){
        // 1 --> 3 --> 8 --> 10 --> 6 --> 14
        threadedBinaryTree.preOrder();
        threadedBinaryTree.threadedNodesPre();
        System.out.println(node4.getLeft().getId());
        System.out.println(node4.getRight().getId());
        threadedBinaryTree.threadedPreOrder();
    }

    @Test
    public void testThreadedInfixOrder() {
        // 8 --> 3 --> 10 --> 1 --> 14 --> 6
        threadedBinaryTree.infixOrder();
        threadedBinaryTree.threadedNodesInfix();
        System.out.println("node  10 --> " + node5.getLeft());
        System.out.println("node  10 -->  " + node5.getRight());
        // 8 --> 3 --> 10 --> 1 --> 14 --> 6
        threadedBinaryTree.threadedInfixOrder();
    }

    @Test
    public void testThreadedPostOrder(){
        // 8 --> 10 --> 3 --> 14 --> 6 --> 1
        threadedBinaryTree.postOrder();
        threadedBinaryTree.threadedNodesPost();
        System.out.println(node6.getLeft());
        System.out.println(node6.getRight());
        threadedBinaryTree.threadedPostOrder();

    }

}
