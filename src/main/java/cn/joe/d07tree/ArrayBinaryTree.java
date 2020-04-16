package cn.joe.d07tree;

/**
 * 用数组实现顺序存储二叉树
 *
 * @author Joe
 * @create 2020/4/15 20:54
 */
public class ArrayBinaryTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree binaryTree = new ArrayBinaryTree(arr);
        // 1 --> 2 --> 4 --> 5 --> 3 --> 6 --> 7
        binaryTree.preOrder();
        // 4 --> 2 --> 5 --> 1 --> 6 --> 3 --> 7
        binaryTree.infixOrder();
        // 4 --> 5 --> 2 --> 6 --> 7 --> 3 --> 1
        binaryTree.postOrder();
    }

    /**
     * 存储数据节点的数组
     */
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
        System.out.println();
    }

    /**
     * 完成顺序存储二叉树的前序遍历
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        isValid(index);
        System.out.print(arr[index] + " --> ");
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        if ((index + 1) * 2 < arr.length) {
            preOrder(2 * (index + 1));
        }
    }

    public void infixOrder() {
        this.infixOrder(0);
        System.out.println();
    }

    public void infixOrder(int index) {
        isValid(index);
        if ((index * 2 + 1) < arr.length) {
            infixOrder(2 * index + 1);
        }
        System.out.print(arr[index] + " --> ");
        if ((index + 1) * 2 < arr.length) {
            infixOrder(2 * (index + 1));
        }
    }

    public void postOrder() {
        this.postOrder(0);
        System.out.println();
    }

    public void postOrder(int index) {
        isValid(index);
        if ((index * 2 + 1) < arr.length) {
            postOrder(2 * index + 1);
        }
        if ((index + 1) * 2 < arr.length) {
            postOrder(2 * (index + 1));
        }
        System.out.print(arr[index] + " --> ");
    }

    private void isValid(int index) throws RuntimeException {
        if (arr == null || arr.length == 0 || index < 0) {
            throw new RuntimeException("array or index error");
        }
    }

}
