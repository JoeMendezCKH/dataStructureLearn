package com.joe.datastructure.part3;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author ckh
 * @create 9/25/20 9:23 AM
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        if (size() >= 0) {
            System.arraycopy(old, 0, theItems, 0, size());
        }
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    private void add(int idx, AnyType x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        if (theSize - idx >= 0) {
            System.arraycopy(theItems, idx, theItems, idx + 1, theSize - idx);
        }
        theItems[idx] = x;
        theSize++;
    }

    public AnyType remove(int idx) {
        AnyType removedItem = theItems[idx];

        /*
            for (int i = idx; i < size() - 1; i++) {
                theItems[i] = theItems[i + 1];
            }
         */
        if (size() - 1 - idx >= 0) {
            System.arraycopy(theItems, idx + 1, theItems, idx, size() - 1 - idx);
        }
        theSize--;

        return removedItem;
    }

    /**
     * Q309
     *
     * @param items
     */
    public void addAll(Iterable<? extends AnyType> items) {
        for (AnyType item : items) {
            add(item);
        }
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements ListIterator<AnyType> {

        private int current = 0;
        boolean backwards = false;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            backwards = false;
            return theItems[current++];
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public AnyType previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            backwards = true;
            return theItems[--current];
        }

        @Override
        public void add(AnyType x) {
            MyArrayList.this.add(current++, x);
        }

        @Override
        public void remove() {
            if (backwards) {
                MyArrayList.this.remove(current--);
            } else {
                MyArrayList.this.remove(--current);
            }
        }

        @Override
        public void set(AnyType x) {
            MyArrayList.this.set(current, x);
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
