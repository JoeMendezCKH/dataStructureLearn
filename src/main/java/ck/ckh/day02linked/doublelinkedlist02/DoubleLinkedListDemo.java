package ck.ckh.day02linked.doublelinkedlist02;

/**
 * @author Joe
 * @create 2020/3/7 14:24
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        MyNode node1 = new MyNode(1, "宋江", "及时雨");
        MyNode node2 = new MyNode(2, "卢俊义", "玉麒麟");
        MyNode node3 = new MyNode(3, "吴用", "智多星");
        MyNode node4 = new MyNode(4, "林冲", "豹子头");

        DoubleLinkedList list = new DoubleLinkedList();
        list.addByOrder(node1);
        list.addByOrder(node4);
        list.addByOrder(node3);
        list.addByOrder(node2);

        list.list();
        System.out.println("+++++++");
//        list.update(3,"java","cpp");
//        list.list();
//        list.delete(8);
//        list.list();

    }
}
