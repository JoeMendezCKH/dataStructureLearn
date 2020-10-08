package com.joe.datastructure.part4;

/**
 * @author ckh
 * @create 10/7/20 11:18 AM
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        public BinaryNode(AnyType element) {
            this.element = element;
        }

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return false;
        }
        int compare = x.compareTo(t.element);

        if (compare < 0) {
            return contains(x, t.left);
        } else if (compare > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    public AnyType findMin() throws NoSuchFieldException {
        if (isEmpty()) {
            throw new NoSuchFieldException();
        }
        return findMin(root).element;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    public AnyType findMax() throws NoSuchFieldException {
        if (isEmpty()) {
            throw new NoSuchFieldException();
        }
        return findMax(root).element;
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }
        int compare = x.compareTo(t.element);

        if (compare < 0) {
            t.left = insert(x, t.left);
        } else if (compare > 0) {
            t.right = insert(x, t.right);
        }

        return t;
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
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
        return t;
    }


    public void printTree() {
        if (isEmpty()) {
            System.out.println("empty tree");
        } else {
            printTree(root);
        }
    }

    /**
     * infix traverse
     */
    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }


    /**
     * Internal method to compute height of a subtree
     * @param t the node that roots the subtree
     */
    private int height(BinaryNode<AnyType> t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
    }
}
