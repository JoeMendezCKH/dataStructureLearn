package com.joe.old.d07tree.application.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树
 *
 * @author Joe
 * @create 2020/4/16 17:11
 */
public class HuffmanTree {

    /**
     * create a huffman tree
     *
     * @param arr huffman tree's value array
     * @return root node of tree
     */
    public Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            // get the min value node
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            // create a new binary tree
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            // delete solved element from list
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // add parent node to the list
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("empty tree");
        }
    }

    public static class Node implements Comparable<Node> {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        private void preOrder(){
            System.out.print(this);
            if (this.left!=null){
                this.left.preOrder();
            }
            if (this.right!=null){
                this.right.preOrder();
            }
        }

        @Override
        public String toString() {
            return " " + value + " -->";
        }

        @Override
        public int compareTo(Node o) {
            // 从小到大
            return this.value - o.value;
        }
    }

}
