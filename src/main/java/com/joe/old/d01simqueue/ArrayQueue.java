package com.joe.old.d01simqueue;

/**
 * ues int array simulation queue
 *
 * @author Joe
 * @create 2020/3/5 9:43
 */
public class ArrayQueue {
    /**
     * pointer the head of the queue, and no include
     */
    private int front;

    /**
     * pointer the end of the queue, arr[rear] is the last value of the queue
     */
    private int rear;

    private int[] arr;
    private int maxSize;

    /**
     * @param maxSize size of the queue
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];

        front = -1;

        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("queue is full");
        } else {
            arr[++rear] = n;
        }
    }

    public int getQueue() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else {
            return arr[++front];
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d] = %d \t", i, arr[i]);
            }
            System.out.println();
        }
    }

    public int peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[front + 1];
    }
}
