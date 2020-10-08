package com.joe.datastructure.part3.question;

/**
 * @author ckh
 * @create 10/6/20 4:45 PM
 */
@SuppressWarnings("rawtypes")
public class Q312SingleListSort {

    private static class Node<T> {
        Node() {
            this(null, null);
        }

        Node(T d) {
            this(d, null);
        }

        Node(T d, Node n) {
            data = d;
            next = n;
        }

        T data;
        Node next;
    }

    private Node<Comparable> head;
    private int theSize;

    public Q312SingleListSort() {
        init();
    }

    public boolean add(Comparable x) {
        if (contains(x)) {
            return false;
        } else {
            Node<Comparable> curr = head.next;
            Node<Comparable> before = head;

            // find the right location
            while (curr != null && curr.data.compareTo(x) < 0) {
                before = curr;
                curr = curr.next;
            }

            before.next = new Node<>(x);
            before.next.next = curr;
            theSize++;
        }
        return true;
    }

    public boolean remove(Comparable x) {
        if (!contains(x)) {
            return false;
        } else {
            Node<Comparable> before = head;
            Node<Comparable> curr = head.next;

            while (!curr.data.equals(x)) {
                before = curr;
                curr = curr.next;
            }
            before.next = curr.next;
            theSize--;
        }
        return true;
    }

    public int size() {
        return theSize;
    }

    public void print() {
        Node<Comparable> curr = head.next;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public boolean contains(Comparable x) {
        Node<Comparable> curr = head.next;
        while ((curr != null) && (curr.data.compareTo(x) <= 0)) {
            if (x.equals(curr.data)) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    private void init() {
        theSize = 0;
        head = new Node<>();
        head.next = null;
    }
}
