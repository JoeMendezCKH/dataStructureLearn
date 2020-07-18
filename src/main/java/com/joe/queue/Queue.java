package com.joe.queue;

/**
 *  利用数组模拟队列
 *
 * 缺点: 只能使用一次, 没有达到复用的效果
 * 改进思路: 使用算法, 将这个数组变为环形队列, 取模 %
 * Created by Mendez on 19/10/15 14:44
 * @author Joe
 */
public class Queue {

    /**
     *  arr[] 该数组用于存放数据, 模拟队列
     *  maxSize 数组的最大容量
     *  front 是指向队列的前一个位置, 即arr[front+1]是第一个数据
     *  rear  是指向队列尾部的指针, arr[rear]是最后一个数据
     */
    private int[] arr;
    private int maxSize;
    private int front;
    private int rear;


    /**
     * 创建队列的构造器
     * @param maxSize 数组的最大容量
     */
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }


    /**
     *  判断队列是否已经满了
     *  当rear == maxSize-1时, 说明rear已经指向了最后一个位置, 队列满了
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * 当rear == front时, 表示没有数据存在, 队列为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear++; // 让real后移
        arr[rear] = n;
    }

    // 获取队列的值
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        front++;
        return arr[front];
    }

    // 显示所有队列的值
    public void showQueue(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i,arr[i]);
        }
    }

    // 显示头数据, 不是取出
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty.");
        }
        return arr[front+1];
    }
}
