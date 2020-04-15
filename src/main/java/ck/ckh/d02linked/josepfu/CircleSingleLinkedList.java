package ck.ckh.d02linked.josepfu;

/**
 * @author Joe
 * @create 2019/10/16 15:40
 */
public class CircleSingleLinkedList {
    /**
     * the first node of the circle single linked without number
     */
    private Node first = null;

    /**
     * add node to constructor a circle single linked
     *
     * @param number node's no
     */
    public void addNode(int number) {
        if (number < 1) {
            throw new RuntimeException("number is invalid value");
        }
        Node curr = null;
        for (int i = 1; i <= number; i++) {
            Node node = new Node(i);
            if (i == 1) {
                first = node;
                // compose a circle
                first.next = first;
                curr = first;
            } else {
                curr.next = node;
                node.next = first;
                curr = node;
            }
        }
    }

    /**
     * traversal linked
     */
    public void list() {
        if (first == null) {
            throw new RuntimeException("linked is empty");
        }
        Node curr = first;
        while (true) {
            System.out.println("编号为" + curr.getNo());
            if (curr.next == first) {
                break;
            }
            curr = curr.next;
        }
    }

    /**
     * according to the number of the user enter,
     * calculate the probability of the node out of circle
     *
     * @param startNum 起始的节点编号
     * @param countNum 计数的个数
     * @param nums     开始时节点的总个数
     */
    public void showNumber(int startNum, int countNum, int nums) {
        if (first == null || startNum < 1 || startNum > nums) {
            throw new RuntimeException("args error");
        }

        Node helper = first;
        // 将helper指向环形链表的最后一个节点, 即 helper.next = first
        while (helper.next != first) {
            helper = helper.next;
        }

        // 让helper和first移动 startNum - 1 次
        for (int i = 0; i < (startNum - 1); i++) {
            first = first.next;
            helper = helper.next;
        }

        // 计数时, 同时移动helper和first countNum-1, 然后出圈
        // 循环直到圈中没有节点
        while (helper != first) {
            // 圈中只有一个节点了
            for (int i = 0; i < (countNum - 1); i++) {
                first = first.next;
                helper = helper.next;
            }
            // now the first point is going out of the node
            System.out.println("out is: " + first.getNo());
            first = first.next;
            helper.next = first;
        }
        System.out.println("the last num is: " + first.getNo());

    }
}
