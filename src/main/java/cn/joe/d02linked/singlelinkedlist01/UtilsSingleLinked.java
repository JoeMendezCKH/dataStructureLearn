package cn.joe.d02linked.singlelinkedlist01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;

/**
 * @author Joe
 * @create 2020/3/5 15:54
 */
public class UtilsSingleLinked {

    /**
     * count the single linked node numbers
     * ignore the head node
     *
     * @param head head node
     * @return effective node counts
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            // empty linked
            return 0;
        }
        int count = 0;
        HeroNode curr = head.next;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    /**
     * find the reverse number k's node
     *
     * @param index k
     * @param head  head node
     * @return
     */
    public static HeroNode findLastIndexNode(int index, HeroNode head) {
        if (head.next == null) {
            throw new RuntimeException("linked is empty");
        }
        int length = getLength(head);
        if (index <= 0 || index > length) {
            throw new RuntimeException("invalid index value");
        }
        HeroNode curr = head.next;
        for (int i = 0; i < (length - index); i++) {
            curr = curr.next;
        }
        return curr;
    }

    /**
     * reverse the single linked list
     * 1. define a init node
     * 2. traversal linked , put the each node before the new node
     * 3. pointer the head node to the new node head
     *
     * @param head target linked list's head node
     */
    public static void reverseLinked(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            throw new RuntimeException("invalid reverse");
        }
        HeroNode curr = head.next;
        // pointer the curr node's next
        HeroNode next = null;
        HeroNode reverseNode = new HeroNode(0, "", "");

        while (curr != null) {
            next = curr.next;
            curr.next = reverseNode.next;
            reverseNode.next = curr;
            curr = next;
        }
        head.next = reverseNode.next;
    }

    /**
     * reverse print linked
     *
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            throw new RuntimeException("linked is empty");
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode curr = head.next;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * merge two linked list and order by ASC
     *
     * @param source
     * @param target
     */
    public static void mergeLinked(HeroNode source, HeroNode target) {
        if (source.next == null || target.next == null) {
            throw new RuntimeException("one of the linked is empty");
        }
        HeroNode curr = source.next;
        HeroNode temp ;

        while (curr != null) {
            temp = curr;
            curr = curr.next;
            temp.next = null;
            addByOrder(temp, target);
        }


    }

    public static void addByOrder(HeroNode node, HeroNode head) {
        HeroNode temp = head;
        /* sign the hero exist */
        boolean flag = false;
        int id = node.getId();
        while (true) {
            if (temp.next == null) {
                // temp is the end
                break;
            } else if (temp.next.getId() > id) {
                //find the location
                break;
            } else if (temp.next.getId() == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("this node id is already exist: " + id + "\t");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }
}
