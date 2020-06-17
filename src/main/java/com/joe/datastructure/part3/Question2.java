package com.joe.datastructure.part3;

/**
 * 通过调整连来交换两个相邻的元素
 * 1. 单链表
 * 2. 双向链表
 *
 * @author Joe
 * @create 2020/6/17 10:21
 */
public class Question2 {
    // ============== singly linked list ==================

    /**
     * beforeP is the cell before the two adjacent cells that are to be swapped.
     */
    public static void swapWithNext(SingleNode beforeP) {
        SingleNode p, afterP;
        p = beforeP.next;
        afterP = p.next;

        // Both p and afterP assumed not null
        if (afterP.next != null) {
            p.next = afterP.next;
        }
        beforeP.next = afterP;
        afterP.next = p;
    }

    // ============== doubly linked lists ====================

    /**
     * p and afterP are cells to be switched.
     */
    public static void swapDoubleWithNext(DoubleNode p) {
        DoubleNode beforeP, afterP;

        beforeP = p.prev;
        afterP = p.next;

        // 画个图会很清晰
        p.next = afterP.next;
        beforeP.next = afterP;
        afterP.next = p;
        p.next.prev = p;
        p.prev = afterP;
        afterP.prev = beforeP;
    }

    static class SingleNode {
        public int data;
        public SingleNode next;
    }

    static class DoubleNode {
        public int data;
        public DoubleNode prev;
        public DoubleNode next;
    }
}
