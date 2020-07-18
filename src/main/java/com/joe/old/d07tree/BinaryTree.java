package com.joe.old.d07tree;

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

    public void removeViolence(int id) {
        if (root != null) {
            if (root.id == id) {
                root = null;
            } else {
                root.removeViolence(id);
            }
        } else {
            System.out.println("empty tree");
        }
    }

    public void removeByRule1(int id) {
        if (root != null) {
            if (root.id == id) {
                root = null;
            } else {
                root.removeByRule1(id);
            }
        } else {
            System.out.println("empty tree");
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
            // System.out.println("hello pre");
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
            // System.out.println("hello infix");
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
                res = this.left.postOrderSearch(id);
            }
            if (res != null) {
                // left find
                return res;
            }
            if (this.right != null) {
                res = this.right.postOrderSearch(id);
            }
            if (res != null) {
                // right find
                return res;
            }
            // System.out.println("hello post");
            if (this.id == id) {
                return this;
            }
            return res;
        }

        /**
         * 递归删除节点:
         * 1. 如果删除的节点是叶子节点, 直接删除该节点
         * 2. 如果删除的节点是非叶子节点, 就删除该子树
         *
         * @param id target id
         */
        private void removeViolence(int id) {
            if (this.left != null && this.left.id == id) {
                this.left = null;
                return;
            }
            if (this.right != null && this.right.id == id) {
                this.right = null;
                return;
            }
            if (this.left != null) {
                this.left.removeViolence(id);
            }
            if (this.right != null) {
                this.right.removeViolence(id);
            }
        }

        /**
         * 递归删除节点:
         * 1. 如果删除的节点是叶子节点, 直接删除该节点
         * 2. 如果删除的节点是非叶子节点
         *  2.1 如果该节点只有一个子节点, 用该子节点替代
         *  2.2 如果该节点有 2 个子节点, 用左子节点替代, 右子节点就不要了
         *
         * @param id target id
         */
        private void removeByRule1(int id) {
            if (this.left != null && this.left.id == id) {
                if (this.left.left == null && this.left.right == null) {
                    this.left = null;
                } else if (this.left.left == null) {
                    this.left = this.left.right;
                } else if (this.left.right == null) {
                    this.left = this.left.left;
                } else {
                    this.left = this.left.left;

                }
                return;
            }
            if (this.right != null && this.right.id == id) {
                if (this.right.left == null && this.right.right == null) {
                    this.right = null;
                } else if (this.right.left == null) {
                    this.right = this.right.right;
                } else if (this.right.right == null) {
                    this.right = this.right.left;
                } else {
                    this.right = this.right.left;
                }
                return;
            }
            if (this.left != null) {
                this.left.removeByRule1(id);
            }
            if (this.right != null) {
                this.right.removeByRule1(id);
            }
        }

        /**
         * 1. 如果删除的节点是叶子节点, 直接删除该节点
         * 2. 如果删除的节点是非叶子节点
         * 2.1 如果该节点只有一个子节点, 用该子节点替代
         * 2.2 如果该节点有 2 个子节点, 用左子节点替代
         *
         * @param node 被删除的节点
         */
        private void delByRules1(Node node) {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                node = node.left;
            }
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
