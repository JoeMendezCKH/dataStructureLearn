package cn.joe.d07tree.application.binarysorttree;


/**
 * 二叉排序树
 *
 * @author Joe
 * @create 2020/4/18 8:58
 */
public class BinarySortTree {

    private Node root;

    public void put(Node node) {
        if (root==null){
            root = node;
        }else {
            root.put(node);
        }
    }

    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
            System.out.println();
        }else {
            System.out.println("empty tree");
        }
    }


    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        /**
         * add
         * 递归方式添加节点, 满足二叉排序树
         *
         * @param node
         */
        public void put(Node node) {
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

        }

        /**
         * infix order
         */
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.print(this.value + " --> ");
            if (this.right != null) {
                this.right.infixOrder();
            }
        }
    }
}
