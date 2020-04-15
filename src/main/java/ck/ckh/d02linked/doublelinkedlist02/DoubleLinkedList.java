package ck.ckh.d02linked.doublelinkedlist02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Joe
 * @create 2020/3/7 14:24
 */
public class DoubleLinkedList {
    /**
     * init a head node
     */
    private MyNode head = new MyNode(0, "", "");

    public MyNode getHead() {
        return head;
    }

    /**
     * traversal double linked list
     */
    public void list() {
        if (head.next == null) {
            throw new RuntimeException("linked is empty");
        }
        MyNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * ignore the id sequence
     * find the last node , add the target node to the double linked list next
     *
     * @param node target node
     */
    public void add(MyNode node) {
        MyNode temp = head;
        // traversal linked
        while (temp.next != null) {
            temp = temp.next;
        }
        // now the temp is pointer the end of the linked
        temp.next = node;
        node.pre = temp;
    }

    @SuppressWarnings("all")
    public void addByOrder(MyNode node) {
        if (head.next == null) {
            // empty linked
            node.pre = head;
            head.next = node;
            return;
        }

        MyNode temp = head;
        while (true) {
            // current node is null , end the linked, insert the node to the temp
            if (temp.next == null) {
                node.pre = temp;
                temp.next = node;
                break;
            }
            if (temp.next.getId() > node.getId()) {
                //temp.next is the location of the insert
                node.next = temp.next;
                temp.next.pre = node;
                temp.next = node;
                node.pre = temp;
                break;
            } else if (temp.next.getId() == node.getId()) {
                int id = node.getId();
                throw new RuntimeException("the node id " + id + "is already exist , can't to add");
            }
            temp = temp.next;
        }
    }


    /**
     * update the node information from id
     * same to the single linked
     */
    public void update(int id, String name, String nickName) {
        if (head.next == null) {
            throw new RuntimeException("linked is empty");
        }
        MyNode temp = head.next;

        Map<Boolean, MyNode> map = findLocation(temp, id);
        temp = (MyNode) map.values().toArray()[0];
        boolean flag = (boolean) map.keySet().toArray()[0];

        if (flag) {
            temp.setName(name);
            temp.setNickName(nickName);
        } else {
            throw new RuntimeException("the id " + id + " is not exist");
        }
    }

    /**
     * we can directly find the node which we want to delete
     *
     * @param id
     * @return
     */
    public boolean delete(int id) {
        if (head.next == null) {
            throw new RuntimeException("linked is empty, invalid delete");
        }
        MyNode temp = head.next;

        Map<Boolean, MyNode> map = findLocation(temp, id);
        temp = (MyNode) map.values().toArray()[0];
        boolean flag = (boolean) map.keySet().toArray()[0];

        if (flag) {
            temp.pre.next = temp.next;
            // if the temp is the last node , then do not execute next line
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("this id is not exist : " + id);
        }
        return flag;
    }

    /**
     * according to the id , find the location of the node
     *
     * @param temp first node location
     * @param id   node id
     * @return find result
     */
    private Map<Boolean, MyNode> findLocation(MyNode temp, int id) {
        Map<Boolean, MyNode> map = new HashMap<>(16);
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // end linked's next
                break;
            }
            if (temp.getId() == id) {
                // FIND
                flag = true;
                break;
            }
            temp = temp.next;
        }
        map.put(flag, temp);
        return map;
    }
}

