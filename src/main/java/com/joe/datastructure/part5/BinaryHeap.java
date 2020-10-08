package com.joe.datastructure.part5;

import com.joe.datastructure.UnderflowException;

// BinaryHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//               or an array containing initial items
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Throws UnderflowException as appropriate


/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 * <p>
 * 对于数组中任一位置 i 上的元素，左儿子在 2i，右儿子在 2i+1，父节点在 i/2 向下取整
 *
 * @author Mark Allen Weiss
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    /**
     * Construct the binary heap.
     */
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Construct the binary heap.
     *
     * @param capacity the capacity of the binary heap.
     */
    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (AnyType[]) new Comparable[capacity + 1];
    }

    /**
     * Construct the binary heap given an array of items.
     */
    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        // 提前扩容 10%
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (AnyType item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * <p>
     * 对于数组中任一位置 i 上的元素，左儿子在 2i，右儿子在 2i+1，父节点在 i/2 向下取整
     * <p>
     * Looked
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }

        // Percolate up  上滤
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }


    /**
     * Looked
     */
    private void enlargeArray(int newSize) {
        AnyType[] old = array;
        array = (AnyType[]) new Comparable[newSize];
        System.arraycopy(old, 0, array, 0, old.length);
    }

    /**
     * Find the smallest item in the priority queue.
     * <p>
     * Looked
     *
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType findMin() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return array[1];
    }

    /**
     * Remove the smallest item from the priority queue.
     *
     * @return the smallest item, or throw an UnderflowException if empty.
     * <p>
     * Looked
     */
    public AnyType deleteMin() {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * Test if the priority queue is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty() {
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Number of elements in heap
     */
    private int currentSize;


    /**
     * The heap array
     */
    private AnyType[] array;

    /**
     * Internal method to percolate down in the heap.
     *
     * @param hole the index at which the percolate begins.
     *             <p>
     *             Looked
     */
    private void percolateDown(int hole) {

        int child;
        AnyType tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {

            child = hole * 2;

            // child != currentSize 保证了不会越界
            // 因为如果 hole 只有一个子节点的话，一定是在其 2i 位置，而 2i 也就是 currentSize
            // 这是用数组模拟堆的必然的性质，TQL
            if (child != currentSize &&
                    array[child + 1].compareTo(array[child]) < 0) {
                // 右子节点的值更小
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                // 左子节点的值更小
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    /**
     * Test program
     */
    public static void main(String[] args) {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>();
        int i = 37;

        for (i = 37; i != 0; i = (i + 37) % numItems) {
            h.insert(i);
        }
        for (i = 1; i < numItems; i++) {
            Integer min = h.deleteMin();
            if (min != i) {
                System.out.println("Oops! " + i);
            }
            System.out.println("min = " + min);

        }

//        BinaryHeap<Integer> h = new BinaryHeap<>();
//        for (int i = 3; i < 7; i++) {
//            h.insert(i);
//        }
//
//        h.insert(1);
//        h.insert(2);
        System.out.println("===");
    }
}
