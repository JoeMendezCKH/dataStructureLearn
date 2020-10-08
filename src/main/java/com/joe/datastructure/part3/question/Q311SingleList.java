package com.joe.datastructure.part3.question;

/**
 * @author ckh
 * @create 10/6/20 4:24 PM
 */
public class Q311SingleList {
    private static class Node {
        Integer data;

        Node next;

        public Node() {
            this(null, null);
        }

        public Node(Integer data) {
            this(data, null);
        }

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int theSize;

    public Q311SingleList() {
        init();
    }

    private void init() {
        theSize = 0;
        head = new Node();
        head.next = null;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Integer x) {
        Node curr = head.next;
        while (curr != null) {
            if (x.equals(curr.data)) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    public boolean add(Integer data) {
        if (contains(data)) {
            return false;
        } else {
            Node node = new Node(data);
            node.next = head.next;
            head.next = node;
            theSize++;
        }
        return true;
    }

    public boolean remove(Integer data) {
        if (!contains(data)) {
            return false;
        } else {
            Node before = this.head;
            Node curr = head.next;

            while (!curr.data.equals(data)) {
                before = curr;
                curr = curr.next;
            }
            before.next = curr.next;
            theSize--;
        }
        return true;
    }

    public void show() {
        Node curr = head.next;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
