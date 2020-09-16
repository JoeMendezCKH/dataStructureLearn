package com.joe.janzhi;


import javax.swing.tree.TreeNode;
import java.util.HashMap;

/**
 * Offer 07. 重建二叉树
 *
 * @author ckh
 * @create 9/16/2020 8:51 PM
 */
public class BuildTree07 {

    /**
     * 标记中序遍历
     */
    int[] preorder;

    /**
     * 保留的先序遍历
     */
    HashMap<Integer, Integer> map = new HashMap<>();


    /**
     * 前序遍历的第一个节点是根节点
     * 找到根节点在中序遍历中的位置，在根节点之前被访问的节点都位于左子树，在根节点之后被访问的节点都位于右子树
     * 由此可知左子树和右子树分别有多少个节点
     * <p>
     * 利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
     * 左右子树，递归
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        // 保存中序遍历的索引顺序,方便获取子树长度
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(0, 0, inorder.length - 1);
    }

    /**
     * @param preRootIdx 根节点索引
     * @param inLeftIdx  左边界
     * @param inRightIdx 右边界
     */
    public TreeNode recursive(int preRootIdx, int inLeftIdx, int inRightIdx) {
        // 相等就是自己
        if (inLeftIdx > inRightIdx) {
            return null;
        }
        // preRootIdx 是在先序里面的
        TreeNode root = new TreeNode(preorder[preRootIdx]);

        // 有了先序的,再根据先序的，在中序中获 当前根的索引
        int idx = map.get(preorder[preRootIdx]);

        // 左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是 left，右边边界是中间区分的 idx-1
        root.left = recursive(preRootIdx + 1, inLeftIdx, idx - 1);

        //由根节点在中序遍历的idx 区分成2段,idx 就是根

        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
        // preRootIdx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - inLeftIdx +1) 。最后+1就是右子树的根了
        root.right = recursive(preRootIdx + (idx - 1 - inLeftIdx + 1) + 1, idx + 1, inRightIdx);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] infix = {9, 3, 15, 20, 7};
        BuildTree07 buildTree07 = new BuildTree07();
        TreeNode treeNode = buildTree07.buildTree(pre, infix);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
