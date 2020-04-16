package cn.joe.d03stack;

import java.util.Scanner;

/**
 * 数组模拟栈
 *
 * @author Joe
 * @create 2020/3/7 14:24
 */
public class ArraySimStack {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        // 创建一个队列, 测试一下Queue
        // 接收用户输入
        String key;
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("(show) 显示队列");
            System.out.println("(exit) 退出程序");
            System.out.println("(push) 入栈");
            System.out.println("(pop) 出栈");
            // System.out.println("h(head) 查看队列头的数据"); s
            key = in.next();
            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "pop":
                    try {
                        int pop = arrayStack.pop();
                        System.out.println("pop is : " + pop);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "push":
                    System.out.println("please enter a value");
                    int value = in.nextInt();
                    arrayStack.push(value);
                    break;
                case "exit":
                    in.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            System.out.println("=============");
        }
        System.out.println("exit the programing");
    }
}

class ArrayStack {
    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 模拟栈的数组
     */
    private int[] stack;

    /**
     * 栈顶, 没有数据时为-1
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 栈满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int result = stack[top];
        top--;
        return result;
    }

    /**
     * 遍历栈, 从栈顶显示
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}
