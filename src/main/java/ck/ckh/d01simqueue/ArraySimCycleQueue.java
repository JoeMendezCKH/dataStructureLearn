package ck.ckh.d01simqueue;

/**
 * ues int array simulation cycle queue
 *
 * @author Joe
 * @create 2020/3/5 9:43
 */
public class ArraySimCycleQueue {
    /**
     * arr[front] is the first value of the queue
     */
    private int front;

    /**
     * pointer the location of the last value's next location
     * this location is a promise
     * arr[rear] is the second last value
     * the consequence is that actually arr's value number is decrease 1
     * and the effective number is (rear - front + maxSize) % maxSize
     */
    private int rear;

    private int[] arr;
    private int maxSize;

    /**
     * @param maxSize size of the queue
     */
    public ArraySimCycleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * the condition of the full is
     * (rear + 1) % maxSize == front
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * the condition of the empty is
     * rear == front
     */
    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("queue is full");
        } else {
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }
    }

    public int getQueue() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else {
            int temp = arr[front];
            front = (front + 1) % maxSize;
            return temp;
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
        } else {
            for (int i = front; i < (front + ((rear - front + maxSize) % maxSize)); i++) {
                System.out.printf("arr[%d] = %d \t", (i % maxSize), arr[(i % maxSize)]);
            }
            System.out.println();
        }
    }

    public int peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[front];
    }
}
