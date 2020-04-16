package cn.joe.queue;

import java.util.Scanner;

/**
 * 数组模拟队列, 实现元素的插入, 取出, 查看数据
 * @author Joe
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个队列, 测试一下Queue
        Queue queue = new Queue(3);
        // 接收用户输入
        char key = ' ';
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show) 显示队列");
            System.out.println("e(exit) 退出程序");
            System.out.println("a(add) 添加数据到队列");
            System.out.println("g(get) 从队列取出数据");
            System.out.println("h(head) 查看队列头的数据");
            key = in.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    in.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("please enter a value");
                    int value = in.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.println("the value is : " + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = queue.headQueue();
                        System.out.println("head is " + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
            System.out.println("=============");
        }
        System.out.println("exit the programing");
    }
}


