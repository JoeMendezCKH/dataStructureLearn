package com.joe.datastructure.part3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author ckh
 * @create 10/6/20 9:47 AM
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

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

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void doClear() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int index, AnyType data) {
        addBefore(getNode(index, 0, size()), data);
    }

    public AnyType get(int index) {
        return getNode(index).data;
    }

    public AnyType set(int index, AnyType newVal) {
        return set(getNode(index), newVal);
    }

    public AnyType set(Node<AnyType> p, AnyType newVal) {
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public AnyType remove(int index) {
        return remove(getNode(index));
    }


    /**
     * adds an item to this collection, at specified position p
     *
     * @param p Node to add before
     * @param x Any Object
     */
    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    /**
     * Removes the object contained in Node p
     *
     * @param p the Node containing the object
     * @return the item was removed from the collection
     */
    private AnyType remove(Node<AnyType> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }


    private Node<AnyType> getNode(int index) {
        return getNode(index, 0, size() - 1);
    }

    /**
     * Gets the Node at postition index, which must range from lower to upper
     *
     * @param index index to search at
     * @param lower lower lowest valid index
     * @param upper upper highest valid index
     * @return internal node corresponding to index
     * @throws IndexOutOfBoundsException if index is not between lower and upper, inclusive
     */
    private Node<AnyType> getNode(int index, int lower, int upper) {
        Node<AnyType> p;
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > 0; i--) {
                p = p.prev;

            }
        }
        return p;
    }

    /**
     * Q303
     */
    public boolean contains(AnyType x) {
        Node<AnyType> p = beginMarker.next;
        while (p != endMarker && !(p.data.equals(x))) {
            p = p.next;
        }
        return p != endMarker;
    }

    public void removeAll(Iterable<? extends AnyType> items) {
        Iterator<AnyType> iterator = iterator();
        for (AnyType item : items) {

            while (iterator.hasNext()) {
                AnyType element = iterator.next();
                if (element.equals(item)) {
                    iterator.remove();
                }
            }

        }
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements ListIterator<AnyType> {

        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;


        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }

        @Override
        public boolean hasPrevious() {
            return current.prev != beginMarker;
        }

        @Override
        public AnyType previous() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            current = current.prev;
            AnyType previousItem = current.data;
            okToRemove = true;
            return previousItem;
        }

        @Override
        public void add(AnyType x) {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            MyLinkedList.this.addBefore(current.next, x);

        }

        @Override
        public void set(AnyType newVal) {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            MyLinkedList.this.set(current.next, newVal);

        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
    }
}
