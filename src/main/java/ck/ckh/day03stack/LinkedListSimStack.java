package ck.ckh.day03stack;

import java.util.Scanner;


/**
 * 链表模拟栈
 *
 * @author Joe
 * @create 2020/3/7 14:24
 */
public class LinkedListSimStack {
    public static void main(String[] args) {

        LinkedStack ls = new LinkedStack();

        // 接收用户输入
        String key;
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("(show) 显示队列");
            System.out.println("(exit) 退出程序");
            System.out.println("(push) 入栈");
            System.out.println("(pop) 出栈");
            // System.out.println("h(head) 查看队列头的数据");s
            key = in.next();
            switch (key) {
                case "show":
                    ls.list();
                    break;
                case "pop":
                    try {
                        Node pop = ls.pop();
                        System.out.println("pop is : " + pop);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "push":
                    System.out.println("please enter a value");
                    int value = in.nextInt();
                    Node node = new Node(value);
                    ls.push(node);
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

class LinkedStack {

    /**
     * 链表的头节点, 不能移动
     */
    public Node head = new Node(0);

    /**
     * 临时变量, 记录栈顶的位置
     */
    Node temp = head;

    /**
     * 栈空
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 入栈
     */
    public void push(Node newNode) {
        // head的next 指向新的节点
        temp.next = newNode;
        // 将栈顶移动到新的节点
        temp = temp.next;
    }

    /**
     * 出栈
     */
    public Node pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        // 辅助节点, 找到当前节点所在的位置
        Node pre = head;
        while (pre.next != temp) {
            pre = pre.next;
        }
        // 此时, pre.next就是要删除的节点 ==  temp(是栈顶元素)
        /*pre.next = temp.next;
        int value = temp.no;
        temp = pre;
        return value;*/
        Node vo = pre.next;
        pre.next = temp.next;
        temp = pre;

        return vo;
    }

    /**
     * 遍历
     */
    public void list() {
        temp = head;
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }


}

class Node {
    public int no;
    public Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}

