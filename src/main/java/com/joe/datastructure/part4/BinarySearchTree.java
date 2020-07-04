package com.joe.datastructure.part4;

/**
 * 二叉查找树, 左边小于当前节点, 右边大于当前节点
 *
 * @author Joe
 * @create 2020/7/3 14:59
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    /**
     * internal method to find an item in a subtree
     *
     * @param x is item to search for
     * @param t the node that roots the subtree
     * @return true if the item is found
     */
    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            // 尾递归, 递归调用是整个函数体中最后执行的语句且它的返回值不属于表达式的一部分
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    public T findMin() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return findMin(root).element;
    }

    /**
     * Internal method to find the smallest item in a subtree
     *
     * @param t the node that roots the subtree
     * @return null or result of min node
     */
    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null) {
            return null;
        } else if (t.left != null) {
            return findMin(t.left);
        } else {
            return t;
        }
    }

    public T findMax() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return findMax(root).element;
    }

    private BinaryNode<T> findMax(BinaryNode<T> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    /**
     * insert into a subtree
     *
     * @param x the item to insert
     * @param t the node that roots the subtree
     * @return the new root of subtree
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null) {
            return new BinaryNode<>(x);
        }
        int compare = x.compareTo(t.element);
        if (compare < 0) {
            t.left = insert(x, t.left);
        } else if (compare > 0) {
            t.right = insert(x, t.right);
        }
        return t;
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    /**
     * remove from a subtree
     *
     * @param x the item to remove
     * @param t the node that roots the subtree
     * @return the new root of subtree
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null) {
            // item not found, do nothing
            return null;
        }
        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            // two children
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            // single child
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    public void printTree() {
        printTree(root);
    }

    /**
     * Internal method to print a subtree in sorted order.
     *
     * @param t the node that roots the subtree.
     */
    private void printTree(BinaryNode<T> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    /**
     * 二叉树的节点
     */
    private static class BinaryNode<T> {

        /**
         * data in the node
         */
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T element) {
            this(element, null, null);
        }

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
