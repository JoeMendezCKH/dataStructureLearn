package com.joe.datastructure.part3;

import java.io.ObjectStreamField;
import java.util.Comparator;

/**
 * question 11 的 排序版
 *
 * @author Joe
 * @create 2020/6/24 9:00
 */
public class Question12SingleListSorted {

    private Node<Comparable<Object>> head;
    private int theSize;

    public Question12SingleListSorted() {
        init();
    }

    private void init() {
        theSize = 0;
        head = new Node<>();
        head.next = null;
    }

    boolean add(Comparable<Object> x) {
        if (contains(x)) {
            return false;
        } else {
            Node<Comparable<Object>> p = head.next;
            Node<Comparable<Object>> trailer = head;
            while (p != null && p.data.compareTo(x) < 0) {
                trailer = p;
                p = p.next;
            }
            trailer.next = new Node<>(x);
            trailer.next.next = p;
            theSize++;
        }
        return true;
    }

    boolean contains(Comparable<Object> x) {
        Node<Comparable<Object>> curr = head.next;
        while (curr != null && curr.data.compareTo(x) <= 0) {
            if (x.equals(curr.data)) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    void print() {
        Node<Comparable<Object>> curr = head.next;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    boolean remove(Comparable<Object> x) {
        if (!contains(x)) {
            return false;
        } else {
            Node<Comparable<Object>> curr = head.next;
            Node<Comparable<Object>> trailer = head;
            while (!curr.data.equals(x)) {
                trailer = curr;
                curr = curr.next;
            }
            trailer.next = curr.next;
            theSize--;
        }
        return true;
    }

    int size() {
        return theSize;
    }


    private static class Node<T extends Comparable<Object>> {
        Node<T> next;
        T data;

        Node() {
            this(null, null);
        }

        Node(T d) {
            this(d, null);
        }

        Node(T d, Node<T> n) {
            data = d;
            next = n;
        }
    }
}

