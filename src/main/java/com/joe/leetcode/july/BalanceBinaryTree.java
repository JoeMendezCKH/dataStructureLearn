package com.joe.leetcode.july;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 将二叉搜索树变平衡
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 * 如果有多种构造方法，请你返回任意一种。
 * <p>
 *        1                         2
 *         \                      /  \
 *          2                    1    3
 *           \                         \
 *            3                         4
 *             \
 *              4
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * <p>
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 *  
 * 提示：
 * 树节点的数目在 1 到 10^4 之间。
 * 树节点的值互不相同，且在 1 到 10^5 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joe
 * @create 2020/7/3 21:33
 */
public class BalanceBinaryTree {

    public TreeNode balanceBst(TreeNode root) {
        List<Integer> sortList = new ArrayList<>();
        // 中序遍历构造有序链表
        inOrder(root, sortList);
        // 有序链表构造平衡二叉树
        return buildTree(sortList, 0, sortList.size() - 1);
    }

    /**
     * 中序遍历二叉树, 存放至 list 中
     *
     * @param node      root
     * @param sortList  升序序列
     */
    private void inOrder(TreeNode node, List<Integer> sortList) {
        if (node != null) {
            inOrder(node.left, sortList);
            sortList.add(node.val);
            inOrder(node.right, sortList);
        }
    }

    /**
     * 有序链表构造平衡二叉树
     *
     * @param sortList 中序遍历的升序列表
     * @param start    left
     * @param end      right
     * @return new root
     */
    private TreeNode buildTree(List<Integer> sortList, int start, int end) {
        if (start > end) {
            return null;
        }
        // 中间节点为root
        int mid = start + (end - start >> 1);
        TreeNode root = new TreeNode(sortList.get(mid));
        // 递归构造左右子树
        root.left = buildTree(sortList, start, mid - 1);
        root.right = buildTree(sortList, mid + 1, end);
        // 返回root
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
