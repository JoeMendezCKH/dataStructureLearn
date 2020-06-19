package com.joe.datastructure.part3;

/**
 * 实现单链表, 只有一个头节点, 无尾节点, 只保留头节点的引用
 *
 * @author Joe
 * @create 2020/6/17 14:34
 */
public class Question11SingleList {


    private Node<Object> head;
    private int theSize;

    public Question11SingleList() {
        init();
    }

    boolean add(Object x) {
        if (contains(x)) {
            return false;
        } else {
            // 头插法
            Node<Object> p = new Node<>(x);
            p.next = head.next;
            head.next = p;
            theSize++;
        }
        return true;
    }
//    boolean remove(Object x){
//        if (!contains(x)){
//            return false;
//        }
//        Node<Object> curr = head.next;
//    }

    boolean contains(Object x) {
        Node<Object> node = head.next;
        while (node != null) {
            if (x.equals(node.data)) {
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    int size() {
        return theSize;
    }

    void print() {
        Node<Object> p = head.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    void init() {
        theSize = 0;
        head = new Node<>();
        head.next = null;
    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node() {
            this(null, null);
        }

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
