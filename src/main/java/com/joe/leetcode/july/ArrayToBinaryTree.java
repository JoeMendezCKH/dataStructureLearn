package com.joe.leetcode.july;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *         0
 *        / \
 *      -3   9
 *      /   /
 *    -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joe
 * @create 2020/7/3 21:06
 */
public class ArrayToBinaryTree {
    public static void main(String[] args) {

    }
    /**
     * 二叉搜索树的中序遍历是升序序列，题目给定的数组是按照升序排序的有序数组，
     * 因此可以确保数组是二叉搜索树的中序遍历序列。
     *
     * @param nums 中序遍历序列
     * @return root
     */
    public TreeNode sortedArrayToBst(int[] nums) {
        return inOrderBuild(nums, 0, nums.length - 1);
    }

    private TreeNode inOrderBuild(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = inOrderBuild(nums, left, mid - 1);
        root.right = inOrderBuild(nums, mid + 1, right);
        return root;

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
