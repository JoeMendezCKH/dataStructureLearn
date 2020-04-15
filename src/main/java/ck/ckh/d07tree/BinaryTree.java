package ck.ckh.d07tree;

import lombok.ToString;

import java.awt.*;
import java.util.OptionalDouble;

/**
 * @author Joe
 * @create 2020/4/15 16:13
 */
public class BinaryTree {

    private Node root;

    public void setRoot(Node node) {
        this.root = node;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
            System.out.println();
        } else {
            System.out.println("binary tree is empty");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
            System.out.println();
        } else {
            System.out.println("binary tree is empty");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
            System.out.println();
        } else {
            System.out.println("binary tree is empty");
        }
    }


    /**
     * 前序查找
     *
     * @param id id
     */
    public Node preOrderSearch(int id) {
        if (root != null) {
            return this.root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    public Node infixOrderSearch(int id) {
        if (root != null) {
            return this.root.infixOrderSearch(id);
        } else {
            return null;
        }
    }

    public Node postOrderSearch(int id) {
        if (root != null) {
            return this.root.postOrderSearch(id);
        } else {
            return null;
        }
    }

    public static class Node {
        private int id;
        private int data;
        private Node left;
        private Node right;

        public Node(int id, int data) {
            this.id = id;
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        /**
         * 前序遍历: 父 --> 左 --> 右
         */
        private void preOrder() {
            System.out.print(this + " --> ");
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        /**
         * 中序遍历: 左 --> 父 --> 右
         */
        private void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.print(this + " --> ");
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        /**
         * 后序遍历: 左 --> 右 --> 父
         */
        private void postOrder() {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.print(this + " --> ");
        }

        /**
         * 前序查找
         *
         * @param id 查找id
         * @return target || null
         */
        private Node preOrderSearch(int id) {
            if (this.id == id) {
                return this;
            }
            Node res = null;
            if (this.left != null) {
                res = this.left.preOrderSearch(id);
            }
            if (res != null) {
                // left find
                return res;
            }
            if (this.right != null) {
                res = this.right.preOrderSearch(id);
            }
            return res;
        }

        private Node infixOrderSearch(int id) {
            Node res = null;
            if (this.left != null) {
                res = this.left.infixOrderSearch(id);
            }
            if (res != null) {
                // left find
                return res;
            }
            if (this.id == id) {
                return this;
            }
            if (this.right != null) {
                res = this.right.infixOrderSearch(id);
            }
            return res;
        }

        private Node postOrderSearch(int id) {
            Node res = null;
            if (this.left != null) {
                res = this.left.preOrderSearch(id);
            }
            if (res != null) {
                // left find
                return res;
            }
            if (this.right != null) {
                res = this.right.preOrderSearch(id);
            }
            if (res != null) {
                // right find
                return res;
            }
            if (this.id == id) {
                return this;
            }
            return res;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", data=" + data +
                    '}';
        }
    }
}
