package cn.joe.d06hashtable.newer;

import lombok.ToString;

/**
 * 自定义的哈希表
 *
 * @author Joe
 * @create 2020/4/15 14:10
 */
public class MyHashTable {

    private LinkedList[] linkedListArray;
    private int size;

    public MyHashTable(int size) {
        this.size = size;
        linkedListArray = new LinkedList[size];
        // bug!!! init the linked list
        for (int i = 0; i < size; i++) {
            linkedListArray[i] = new LinkedList();
        }
    }

    /**
     * insert table by id
     *
     * @param id   id
     * @param data data
     */
    public void put(int id, int data) {
        int linkedListNo = hash(id);
        Node node = new Node(id, data);
        linkedListArray[linkedListNo].put(node);
    }

    /**
     * traverse all linkedList, hash table
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.print("No " + (i + 1) + "'s ");
            try {
                linkedListArray[i].list();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * delete by id
     *
     * @param id id
     */
    public void remove(int id) {
        int linkedNo = hash(id);
        Node node = linkedListArray[linkedNo].remove(id);
        if (node == null) {
            System.out.println("no result");
        } else {
            System.out.println(node + " is deleted");
        }
    }

    /**
     * find by id
     *
     * @param id
     */
    public void get(int id) {
        int linkedNo = hash(id);
        Node node = linkedListArray[linkedNo].get(id);
        if (node == null) {
            System.out.println("no result");
        } else {
            System.out.printf("在第%d条链表中找到, id=%d, data=%d\n", linkedNo + 1, id, node.data);
        }

    }

    /**
     * hash by id,  The simplest method is (% size)
     *
     * @param id id
     */
    private int hash(int id) {
        return id % size;
    }


    private static class LinkedList {
        private Node head;

        // Assume: id is auto increment and insert the rear
        private void put(Node node) {
            if (head == null) {
                head = node;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        private Node remove(int id) {
            if (head == null) {
                System.out.println("linked is empty");
                return null;
            }
            Node temp = head;
            Node result = null;
            if (head.id == id) {
                result = head;
                head = temp.next;
                return result;
            }
            while (temp.next != null) {
                // linked list delete node
                if (temp.next.id == id) {
                    result = temp.next;
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
            return result;
        }


        /**
         * find by id
         *
         * @param id
         */
        private Node get(int id) {
            if (head == null) {
                System.out.println("linked is empty");
                return null;
            }
            Node temp = head;
            while (temp != null) {
                // find it
                if (temp.id == id) {
                    break;
                }
                temp = temp.next;
            }
            return temp;
        }

        private void list() {
            if (head == null) {
                throw new RuntimeException("Linked list is empty");
            }
            Node temp = head;
            do {
                System.out.print("-->" + temp);
                temp = temp.next;
            } while (temp != null);
            System.out.println();
//            while (true) {
//                System.out.println(temp);
//                if (temp.next == null) {
//                    break;
//                }
//                temp = temp.next;
//            }
        }


    }


    @ToString(exclude = "next")
    private static class Node {
        int id;
        int data;
        Node next;

        private Node(int id, int data) {
            this.id = id;
            this.data = data;
        }
    }
}
