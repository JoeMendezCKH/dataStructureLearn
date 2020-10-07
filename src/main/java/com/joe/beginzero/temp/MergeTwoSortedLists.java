package com.joe.beginzero.temp;

import javax.sound.midi.Soundbank;

/**
 * @author ckh
 * @create 10/7/20 8:46 PM
 */
public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode result = new ListNode();
        // 辅助遍历
        ListNode temp = result;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        temp.next = temp1 == null ? temp2 : temp1;

        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);

        node1.next = node3;
        node3.next = node5;


        node2.next = node4;
        node4.next = node6;


        ListNode node = mergeTwoLists(node1, node2);

        show(node1);

        show(node2);

        System.out.println("========");
        show(node);
    }

    private static void show(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
