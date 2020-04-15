package ck.ckh.day02linked.josepfu;

/**
 * @author Joe
 * @create 2019/10/16 15:55
 */
public class CircleSingleDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList csl = new CircleSingleLinkedList();
        csl.addNode(9);
        csl.list();
        System.out.println("++++++++++++=");
        csl.showNumber(1,2,9);
    }
}
