package com.joe.datastructure.demo;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Joe
 * @create 2020/6/15 10:30
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;


    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        addBefore(getNode(idx, 0, size()), x);

    }


    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    public AnyType set(int idx, AnyType newVal) {
        Node<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public AnyType remove(int idx) {
        return remove(getNode(idx));
    }

    /**
     * adds an item to this collection, at specified position p
     * items at or after that position are slid one position higher
     *
     * @param p node to add before
     * @param x any object
     */
    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    /**
     * removes the object contained in node p
     *
     * @param p the node containing the object
     * @return the item was removed from the collection
     */
    private AnyType remove(Node<AnyType> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;

        theSize--;
        modCount++;

        return p.data;

    }

    /**
     * gets the node at position idx, which must range from 0 to size()-1
     *
     * @param idx index to search at
     * @return internal node corresponding to idx
     * @throws IndexOutOfBoundsException if idx is not between 0 and size()-1, inclusive
     */
    private Node<AnyType> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    public Node<AnyType> getNode(int idx, int lower, int upper) {
        Node<AnyType> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }

        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType> {

        private Node<AnyType> current = beginMarker.next;
        private int expectModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {
            if (modCount != expectModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            AnyType nexItem = current.data;
            current = current.next;
            okToRemove = true;
            return nexItem;
        }

        @Override
        public void remove() {
            if (modCount != expectModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectModCount++;
            okToRemove = false;
        }
    }

    public boolean contains(AnyType x) {
        Node<AnyType> p = beginMarker.next;
        while (p != endMarker && !(p.data.equals(x))) {
            p = p.next;
        }
        return (p != endMarker);
    }

    // addAll runs in O(N) time, where N is the size of the items collection

    public void addAll(Iterable<? extends AnyType> items) {
        for (AnyType item : items) {
            add(item);
        }
    }

    public void removeAll(Iterable<? extends AnyType> items) {
        AnyType item, element;
        for (AnyType ele : items) {
            item = ele;
            Iterator<? extends AnyType> iterList = iterator();
            while (iterList.hasNext()) {
                element = iterList.next();
                if (element.equals(item)) {
                    iterList.remove();
                }
            }
        }
    }

    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
