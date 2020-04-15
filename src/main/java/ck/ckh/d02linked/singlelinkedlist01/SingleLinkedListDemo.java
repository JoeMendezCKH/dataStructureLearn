package ck.ckh.d02linked.singlelinkedlist01;

/**
 * @author Joe
 * @create 2020/3/5 11:14
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "宋江", "及时雨");
        HeroNode node6 = new HeroNode(6, "卢俊义", "玉麒麟");
        HeroNode node7 = new HeroNode(7, "吴用", "智多星");
        HeroNode node8 = new HeroNode(8, "林冲", "豹子头");

        SingleLinkedList linkedList1 = new SingleLinkedList();
        SingleLinkedList linkedList2 = new SingleLinkedList();
        HeroNode head = linkedList1.getHead();
        HeroNode head2 = linkedList2.getHead();


        linkedList1.addByOrder(node1);
        linkedList1.addByOrder(node5);
        linkedList1.addByOrder(node7);
        linkedList1.addByOrder(node8);

        linkedList2.addByOrder(node6);
        linkedList2.addByOrder(node4);
        linkedList2.addByOrder(node2);
        linkedList2.addByOrder(node3);


        System.out.println("=======");

        linkedList1.update(2, "java", "hadoop");

        linkedList1.list();
        linkedList2.list();
        System.out.println("==");
        /*
        boolean delete = linkedList.delete(2);

        System.out.println(UtilsSingleLinked.getLength(linkedList.getHead()));
        System.out.println(UtilsSingleLinked.findLastIndexNode(2, linkedList.getHead()));
        UtilsSingleLinked.reverseLinked(head);
        linkedList.list();
        */
        UtilsSingleLinked.reversePrint(head);
        UtilsSingleLinked.mergeLinked(head2, head);
        linkedList1.list();

        // video 024
    }
}
