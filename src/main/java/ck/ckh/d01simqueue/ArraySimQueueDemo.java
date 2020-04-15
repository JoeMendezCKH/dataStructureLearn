package ck.ckh.d01simqueue;

import java.util.Scanner;

/**
 * 队列:
 * 是一个有序列表，可以用数组或是链表来实现。遵循先入先出的原则。
 * 即：先存入队列的数据，要先取出。后存入的要后取出
 *
 * @author Joe
 * @create 2020/3/5 9:36
 */
public class ArraySimQueueDemo {
    public static void main(String[] args) {
        char key = ' ';
        boolean loop = true;
        ArraySimCycleQueue queue = new ArraySimCycleQueue(4);
//        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("(s)show queue");
            System.out.println("(g)get data from queue");
            System.out.println("(p)peek queue");
            System.out.println("(a)add data to queue");
            System.out.println("(e)exit queue");
            key = scanner.next().charAt(0);

            loop = switchLoop(queue, scanner, key, loop);

            System.out.println("===========");
        }
        scanner.close();
    }

    private static boolean switchLoop(ArraySimCycleQueue queue, Scanner in, char key, boolean loop) {
        switch (key) {
            case 's':
                queue.showQueue();
                break;
            case 'e':
                loop = false;
                break;
            case 'a':
                System.out.println("enter a number ");
                int value = in.nextInt();
                queue.addQueue(value);
                break;
            case 'g':
                try {
                    System.out.println("value : " + queue.getQueue());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 'p':
                try {
                    System.out.println("header of queue : " + queue.peek());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                break;
        }
        return loop;
    }

//    private static boolean switchLoopArrayCycleQueue(ArrayQueue queue, Scanner in, char key, boolean loop) {
//        switch (key) {
//            case 's':
//                queue.showQueue();
//                break;
//            case 'e':
//                loop = false;
//                break;
//            case 'a':
//                System.out.println("enter a number ");
//                int value = in.nextInt();
//                queue.addQueue(value);
//                break;
//            case 'g':
//                try {
//                    System.out.println("value : " + queue.getQueue());
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            case 'p':
//                try {
//                    System.out.println("header of queue : " + queue.peek());
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            default:
//                break;
//        }
//        return loop;
//    }
}

