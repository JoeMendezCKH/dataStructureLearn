package ck.ckh.queue;

import java.util.Scanner;

/**
 * Created by Mendez on 19/10/6 10:22
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        // 测试
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4); // 有效队列长度只有3, 有一位是空出做标记的
        char key = ' '; // 接收用户输入
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
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    in.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("please enter a value");
                    int value = in.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.println("the value is : " + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println("head is " + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
            System.out.println("=====================");
        }
        System.out.println("exit the programing");
    }
}


