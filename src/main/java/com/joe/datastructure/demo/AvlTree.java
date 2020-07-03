package com.joe.datastructure.demo;

/**
 * @author Joe
 * @create 2020/7/3 16:50
 */
public class AvlTree<T extends Comparable<? super T>> {

    private static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<T> root;

    public AvlTree() {
        this.root = null;
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

    private boolean contains(T x, AvlNode<T> t) {
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

    public T findMax() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return findMax(root).element;
    }

    private AvlNode<T> findMax(AvlNode<T> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    public T findMin() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return findMin(root).element;
    }

    private AvlNode<T> findMin(AvlNode<T> t) {
        if (t != null) {
            while (t.left != null) {
                t = t.left;
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
     * @return the new root of the subtree
     */
    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null) {
            return new AvlNode<>(x);
        }
        int compare = x.compareTo(t.element);
        if (compare < 0) {
            t.left = insert(x, t.left);
        } else if (compare > 0) {
            t.right = insert(x, t.right);
        }
        return balance(t);
    }

    /**
     * Assume t is either balanced or within one of being balanced
     *
     * @param t root of the subtree
     * @return new root
     */
    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null) {
            return null;
        }

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else {
            if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
                if (height(t.right.right) >= height(t.right.left)) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * Rotate binary tree node with left child
     * For AVL trees, this is a single rotation for case 1
     * Update heights, then return new root
     * 可以看 P87 图 4-31
     *
     * @param k2 before root
     * @return new root
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        // 修改height
        // 1. 若 k1.left.height 与 k1.right.height 相差 2 (对应右-右旋转) ,
        //    此时 k1 的高度改变, k1.right高度未变
        // 2. 若 k1.left.height 与 k1.right.height 相差 1 (对应左-右旋转的第一次旋转),
        //    此时 k1 的高度改变, k1.right高度也变化
        // 为了适应上述两种情况,同时修改 k1.height 和 k1.right.height
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(k1.height, height(k2.right)) + 1;
        return k2;
    }

    /**
     * P93 图 4-42
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child
     * For AVL trees, this is a double rotation for case 2
     * Update heights, then return new root
     *
     * @param k3 before root
     * @return new root
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }


    public void remove(T x) {
        root = remove(x, root);
    }

    /**
     * remove form a subtree
     *
     * @param x the item to insert
     * @param t the node that roots the subtree
     * @return the new root of the subtree
     */
    private AvlNode<T> remove(T x, AvlNode<T> t) {
        if (t == null) {
            return null;
        }
        int compare = x.compareTo(t.element);
        if (compare < 0) {
            t.left = remove(x, t.left);
        } else if (compare > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            // tow children
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return balance(t);
    }


    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    private void printTree(AvlNode<T> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }


    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }


    private static class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        public AvlNode(T element) {

            this(element, null, null);
        }

        public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }
}
