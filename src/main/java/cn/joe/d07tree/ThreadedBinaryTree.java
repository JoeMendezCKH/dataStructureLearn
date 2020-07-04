package cn.joe.d07tree;

/**
 * 线索化二叉树
 *
 * @author Joe
 * @create 2020/4/15 21:38
 */
public class ThreadedBinaryTree {

    private Node root;

    /**
     * 为了线索化, 需要一个节点指向当前节点的前驱节点
     */
    private Node prevNode = null;

    public void setRoot(Node node) {
        this.root = node;
    }


    /**
     * 线索化前序遍历
     */
    public void threadedPreOrder() {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.id + " --> ");
            while (temp.getRightType() == 1) {
                temp = temp.right;
                System.out.print(temp.id + " --> ");
            }
            if (temp.getLeftType() == 0) {
                temp = temp.left;
                continue;
            }
            temp = temp.right;
        }
        System.out.println();
    }

    /**
     * 线索化后的中序遍历
     */
    public void threadedInfixOrder() {
        Node temp = root;
        while (temp != null) {
            // find the leftType == 1, after the traverse the temp is change
            // it is that the node is threaded when the leftType == 1
            while (temp.getLeftType() == 0) {
                temp = temp.left;
            }
            System.out.print(temp.id + " --> ");
            // if temp.right is post node , continue output
            while (temp.getRightType() == 1) {
                temp = temp.right;
                System.out.print(temp.id + " --> ");
            }
            temp = temp.right;
        }
        System.out.println();
    }

    /**
     * 线索化后序遍历
     */
    public void threadedPostOrder() {
        Node temp = root;
        Node pre = null;

        while (temp != null && temp.getLeftType() == 0) {
            temp = temp.left;
        }
        while (temp != null) {
            if (temp.getRightType() == 1) {
                System.out.print(temp.id + " --> ");
                pre = temp;
                temp = temp.right;
            } else {
                // 上个处理的节点是当前节点的右节点
                if (temp.right == pre) {
                    System.out.print(temp.id + " --> ");
                    if (temp == root) {
                        return;
                    }
                    pre = temp;
                    temp = temp.getParent();
                } else {
                    temp = temp.right;
                    while (temp != null && temp.getLeftType() == 0) {
                        temp = temp.left;
                    }
                }
            }
        }


        System.out.println();
    }


    public void threadedNodesPre() {
        this.threadedNodesPre(root);
    }

    /**
     * 前序线索化
     *
     * @param node root
     */
    public void threadedNodesPre(Node node) {
        if (node == null) {
            return;
        }
        // 1. 线索化当前
        // 处理当前节点B的前驱A
        if (node.left == null) {
            node.left = prevNode;
            node.setLeftType(1);
        }
        // 处理B的后继节点C, 下一次处理, prevNode 就相当于B节点, node相当于C节点
        if (prevNode != null && prevNode.right == null) {
            prevNode.right = node;
            prevNode.setRightType(1);
        }
        // !!! 修改前驱节点
        prevNode = node;
        // 2. 线索化左子树
        if (node.getLeftType() == 0) {
            threadedNodesPre(node.left);
        }
        // 3. 线索化右子树
        if (node.getRightType() == 0) {
            threadedNodesPre(node.right);
        }
    }

    public void threadedNodesInfix() {
        this.threadedNodesInfix(root);
    }

    /**
     * 中序线索化
     *
     * @param node 当前需要线索化的节点
     */
    public void threadedNodesInfix(Node node) {
        if (node == null) {
            return;
        }
        // 1. 线索化左子树
        if (node.getLeftType() == 0) {
            threadedNodesInfix(node.left);
        }
        // 2. 线索化当前节点
        // 处理当前节点B的前驱A
        if (node.left == null) {
            node.left = prevNode;
            // 表示当前节点的左子节点指向前驱节点
            node.setLeftType(1);
        }
        // 处理B的后继节点C, 下一次处理, prevNode 就相当于B节点, node相当于C节点
        if (prevNode != null && prevNode.right == null) {
            prevNode.right = node;
            prevNode.setRightType(1);
        }
        // !!! 修改前驱节点
        prevNode = node;
        // 3. 线索化右子树
        if (node.getRightType() == 0) {
            threadedNodesInfix(node.right);
        }
    }

    public void threadedNodesPost() {
        this.threadedNodesPost(root);
    }

    public void threadedNodesPost(Node node) {
        if (node == null) {
            return;
        }
        // 1. 线索化左子树
        if (node.getLeftType() == 0) {
            threadedNodesPost(node.left);
        }
        // 2. 线索化右子树
        if (node.getRightType() == 0) {
            threadedNodesPost(node.right);
        }
        // 3. 线索化当前节点
        // 处理当前节点B的前驱A
        if (node.left == null) {
            node.left = prevNode;
            // 表示当前节点的左子节点指向前驱节点
            node.setLeftType(1);
        }
        // 处理B的后继节点C, 下一次处理, prevNode 就相当于B节点, node相当于C节点
        if (prevNode != null && prevNode.right == null) {
            prevNode.right = node;
            prevNode.setRightType(1);
        }
        // !!! 修改前驱节点
        prevNode = node;
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
        /**
         * 父节点, 为了后序线索化的遍历
         */
        private Node parent;

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        /**
         * 规定: leftType == 0 表示指向 子树， leftType == 1表示指向前驱节点
         */
        private int leftType;
        /**
         * 规定: rightType == 0 表示指向 子树， rightType == 1表示指向后继节点
         */
        private int rightType;

        public int getId() {
            return id;
        }

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

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }

        /**
         * 前序遍历: 父 --> 左 --> 右
         */
        private void preOrder() {
            System.out.print(this.id + " --> ");
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
            System.out.print(this.id + " --> ");
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
            System.out.print(this.id + " --> ");
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
         * 2.1 如果该节点只有一个子节点, 用该子节点替代
         * 2.2 如果该节点有 2 个子节点, 用左子节点替代, 右子节点就不要了
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
