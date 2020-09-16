package com.joe.janzhi;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Offer 06. 从尾到头打印链表
 *
 * @author ckh
 * @create 9/16/2020 8:25 PM
 */
public class ReversePrintLinkedList06 {


    /**
     * traverse the linked list and then print the array
     */
    public static int[] reversePrintSelf1(ListNode head) {
        ListNode curr = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int index = 0;
        int[] result = new int[list.size()];
        for (int i = list.toArray().length - 1; i >= 0; i--) {
            result[index] = (Integer) list.get(i);
            index++;
        }

        return result;
    }

    /**
     * rebuild reverse linkedlist
     */
    public static int[] reversePrintSelf2(ListNode head) {

        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{head.val};
        }

        ListNode pre = head;
        ListNode curr = head.next;

        int len = 0;
        while (curr != null) {
            len++;
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        curr = pre;
        head.next = null;

        int[] result = new int[len + 1];

        int index = 0;
        while (curr != null) {
            result[index++] = curr.val;
            curr = curr.next;
        }

        return result;

    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;

        int[] ints = reversePrintSelf2(a);
        System.out.println(Arrays.toString(ints));
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    "}";
        }
    }
}