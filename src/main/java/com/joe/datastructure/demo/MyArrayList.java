package com.joe.datastructure.demo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author Joe
 * @create 2020/6/15 9:46
 */
public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
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

    public T get(int idx) {
        checkIndex(idx);
        return theItems[idx];
    }

    public T set(int idx, T newVal) {
        checkIndex(idx);
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    private void checkIndex(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
//        T[] old = theItems;
//        theItems = (T[]) new Object[newCapacity];
//        for (int i = 0; i < size(); i++) {
//            theItems[i] = old[i];
//        }
        theItems = Arrays.copyOf(theItems, newCapacity);
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    private void add(int idx, T x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
//        for (int i = theSize; i > idx; i--) {
//            theItems[i] = theItems[i - 1];
//        }
        if (theSize - idx >= 0) {
            System.arraycopy(theItems, idx, theItems, idx + 1, theSize - idx);
        }
        theItems[idx] = x;
        theSize++;
    }

    public T remove(int idx) {
        T removedItem = theItems[idx];

//        for (int i = idx; i < size() - 1; i++) {
//            theItems[i] = theItems[i + 1];
//        }

        if (size() - 1 - idx >= 0) {
            System.arraycopy(theItems, idx + 1, theItems, idx, size() - 1 - idx);
        }
        theSize--;
        return removedItem;
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    public java.util.ListIterator<T> listIterator() {
        return new ArrayListIterator();
    }


    // add listIterator support

    private class ArrayListIterator implements ListIterator<T> {

        private int current = 0;

        /**
         * 逆序标志位
         * next 方法 返回的是 theItems[current++]
         * 在删除时要区分一下
         */
        boolean backwards = false;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
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
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            backwards = true;
            return theItems[--current];
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
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
        public void set(T t) {
            MyArrayList.this.set(current, t);
        }

        @Override
        public void add(T t) {
            MyArrayList.this.add(current++, t);
        }
    }

}
