package com.joe.leetcode.july;

import java.util.LinkedList;
import java.util.List;

/**
 * 97
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树
 *
 * @author ckh
 * @create 2020/7/21 9:09
 */
public class UniqueBinaryTree {

    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        for (TreeNode node : treeNodes) {
            node.display(node);
            System.out.println("=================");
        }
        System.out.println(treeNodes);

    }

    public static List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }


        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 想想为什么这行不能放在这里，而放在下面？
            // 因为 左右子树还要递归, 在这里固定了 会导致所有的
//             TreeNode currNode = new TreeNode(i);

            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currNode = new TreeNode(i);
                    currNode.left = left;
                    currNode.right = right;
                    allTrees.add(currNode);
                }
            }
        }

        return allTrees;
    }


    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }

        public void display(TreeNode node) {
            if (node != null) {
                System.out.print(node.val + " -> ");
            } else {
                return;
            }
            if (node.left != null) {
                display(node.left);
            }
            if (node.right!=null){
                display(node.right);
            }
        }
    }
}
