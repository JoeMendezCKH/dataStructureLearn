package com.joe.datastructure.part3.question;

/**
 * 3.2 p67
 *
 * @author ckh
 * @create 10/6/20 2:45 PM
 */
public class Q302 {
    private static class Node {

        public Integer data;
        public Node prev;
        public Node next;

        public Node(Integer data) {
            this.data = data;
        }
    }

    // ========= for single linked list =========

    public static void swapWithNext1(Node beforeP) {

        // assumed p and afterP is not null
        Node p , afterP;
        p = beforeP.next;
        afterP  = p.next;

        p.next = afterP.next;
        beforeP.next = afterP;
        afterP.next = p;
    }

    // ========== for doubly linked lists============

    public static void swapWithNext2(Node p){
        Node beforeP = p.prev;
        Node afterP = p.next;

        p.next = afterP.next;
        afterP.next.prev = p;
        afterP.next = p;
        p.prev = afterP;
        beforeP.next = afterP;
        afterP.prev = beforeP;

//        p.next = afterP.next;
//        beforeP.next = afterP;
//        afterP.next  = p;
//
//        p.next.prev = p;
//        p.prev = afterP;
//        afterP.prev = beforeP;


    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;

        show(node1);

        swapWithNext2(node2);

        show(node1);
    }


    public static void show(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
