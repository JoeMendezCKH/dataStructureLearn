package cn.joe.queue;

/**
 * 数组模拟队列, 环形队列, 解决了之前只能用一次的问题
 *
 * Created by Mendez on 19/10/15 14:56
 * @author Joe
 */
public class CircleArrayQueue {
    private int maxSize;

    // 指向第一个元素
    private int front;

    // 指向最后一个元素...的后一个位置, 空出一个位置作为标记
    private int rear;
    // 放队列的数组
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    // 判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 计算队列的有效长度

    /**
     * 计算队列的有效长度
     * 长度肯定是rear - front的关系
     * 但是随着环形的走, 会将rear放在数组的前面, 此时, rear的值小于front, 所有要加maxsize
     * 加上maxsize后, 初始的第一次循环会过大, 所以取模, 反正取模也没什么坏处..
     * @return
     */
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满了, 加不了");
            return;
        }
        /*arr[(rear % maxSize)] = n;
        rear++; // 让real后移*/
        arr[rear] = n;
        rear = (rear + 1) % maxSize;

    }

    // 获取队列的值
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        /*int res = arr[(front % maxSize)];
        front++;*/
        int res = arr[front];
        front = (front + 1) % maxSize;
        return res;

    }

    // 显示所有队列的值
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        /**
         *  从front开始遍历, 遍历有效数据个数
         */
        for (int i = front; i < (front + size()); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
            // 因为 i++ 后 , 可能导致索引越界
        }
    }

    // 显示头数据, 不是取出
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty.");
        }
        return arr[front];
    }
}
