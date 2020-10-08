package com.joe.datastructure.part4;

import java.util.HashMap;

/**
 * @author ckh
 * @create 10/7/20 3:18 PM
 */
public class AvlTree<AnyType extends Comparable<? super AnyType>> {

    private static class AvlNode<AnyType> {
        AnyType element;
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        int height;

        public AvlNode(AnyType element) {
            this(element, null, null);
        }

        public AvlNode(AnyType element, AvlNode<AnyType> left, AvlNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            height = 0;
        }
    }

    /**
     * return the height of note t, or -1, if null
     */
    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;

    }

    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            return new AvlNode<>(x, null, null);
        }
        int compare = x.compareTo(t.element);
        if (compare < 0) {
            t.left = insert(x, t.left);
        } else if (compare > 0) {
            t.right = insert(x, t.right);
        }

        return balance(t);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    /**
     * Assume t is either balanced or within one of being balanced
     */
    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1
     * update heights, then return new root
     * <p>
     * p87 figure: 4-31
     */
    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * 看图写程序
     */
    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k1) {
        AvlNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(k1.height, height(k2.right)) + 1;
        return k2;
    }

    /**
     * p93 figure:4-42
     */
    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.left = rotateWithRightChild(k3.left);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(16);
        return rotateWithLeftChild(k3);
    }

    /**
     * p89 figure:4-36
     */
    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private AvlNode<AnyType> remove(AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            // item not found; do nothing
            return t;
        }
        int compare = x.compareTo(t.element);

        if (compare < 0) {
            t.left = remove(x, t.left);
        } else if (compare > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }

        return balance(t);
    }

    private AvlNode<AnyType> findMin(AvlNode<AnyType> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

}
