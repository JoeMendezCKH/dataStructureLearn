package com.joe.old.d07tree.application.avltree;

/**
 * @author Joe
 * @create 2020/4/20 8:58
 */
public class AvlTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void put(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.put(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
            System.out.println();
        } else {
            System.out.println("empty tree");
        }
    }

    /**
     * remove node
     *
     * @param value node value
     * @throws RuntimeException empty tree
     */
    public void remove(int value) {
        if (root == null) {
            throw new RuntimeException("empty tree");
        } else {
            Node targetNode = find(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = findParent(value);
            // targetNode is leaf node
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } // targetNode have two son tree
            else if (targetNode.left != null && targetNode.right != null) {
                // two method
//                targetNode.value = removeRightTreeMin(targetNode.right);
                targetNode.value = removeLeftTreeMax(targetNode.left);
            } // targetNode have one son tree
            else {
                if (targetNode.left != null) {
                    if (parent == null) {
                        root = targetNode.left;
                    } else {
                        if (parent.left.value == value) {
                            // targetNode is the left son
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    }
                } else {
                    if (parent == null) {
                        root = targetNode.right;
                    } else {
                        if (parent.left.value == value) {
                            // targetNode is the left son
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    }
                }
            }
        }
    }

    /**
     * @param node as a new tree root node
     * @return min value node
     */
    public int removeRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        // target is the min node
        remove(target.value);
        return target.value;
    }

    public int removeLeftTreeMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        // target is the max node
        remove(node.value);
        return node.value;
    }


    public Node find(int value) {
        if (root == null) {
            return null;
        } else {
            return root.find(value);
        }
    }

    public Node findParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.findParent(value);
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int leftHeight() {
            if (left == null) {
                return 0;
            } else {
                return left.height();
            }
        }

        public int rightHeight() {
            if (right == null) {
                return 0;
            } else {
                return right.height();
            }
        }

        /**
         * @return current node height
         */
        public int height() {
            return Math.max(left == null ? 0 : left.height(),
                    right == null ? 0 : right.height()) + 1;
        }

        /**
         * add
         * 递归方式添加节点, 满足二叉排序树
         *
         * @param node
         */
        private void put(Node node) {
            if (node == null) {
                return;
            }
            if (node.value < this.value) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.put(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.put(node);
                }
            }

            if (rightHeight() - leftHeight() > 1) {
                if (right != null && right.leftHeight() > right.rightHeight()) {
                    right.rightRotate();
                }
                leftRotate();
            } else if (leftHeight() - rightHeight() > 1) {
                if (left != null && left.rightHeight() > left.leftHeight()) {
                    left.leftRotate();
                }
                rightRotate();
            }

        }

        /**
         * infix order
         */
        private void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.print(this.value + " --> ");
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        /**
         * 查找value节点
         *
         * @param value 节点的value
         * @return 对应的节点
         */
        private Node find(int value) {
            if (value == this.value) {
                return this;
            } else if (value < this.value) {
                if (this.left != null) {
                    return this.left.find(value);
                } else {
                    return null;
                }
            } else {
                if (this.right != null) {
                    return this.right.find(value);
                } else {
                    return null;
                }
            }
        }

        /**
         * 查找 value节点的父节点
         *
         * @param value value
         * @return 父节点
         */
        @SuppressWarnings("all")
        private Node findParent(int value) {
            if ((this.left != null && this.left.value == value) ||
                    (this.right != null && this.right.value == value)) {
                return this;
            } else {
                if (value < this.value && this.left != null) {
                    return this.left.findParent(value);
                } else if (value >= this.value && this.right != null) {
                    return this.right.findParent(value);
                } else {
                    return null;
                }
            }
        }

        private void leftRotate() {
            Node newNode = new Node(this.value);
            newNode.left = this.left;
            newNode.right = this.right.left;
            this.value = this.right.value;
            this.right = this.right.right;
            this.left = newNode;
        }

        private void rightRotate() {
            Node node = new Node(this.value);
            node.right = this.right;
            node.left = this.left.right;
            this.value = this.left.value;
            this.left = this.left.left;
            this.right = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
