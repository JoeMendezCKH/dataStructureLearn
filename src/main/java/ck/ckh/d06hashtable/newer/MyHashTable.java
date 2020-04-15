package ck.ckh.d06hashtable.newer;

import lombok.ToString;

import java.nio.channels.NonReadableChannelException;
import java.util.LinkedList;

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
        for (LinkedList linkedList : linkedListArray) {
            try {
                linkedList.list();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
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

        private void list() throws Exception {
            if (head == null) {
                throw new RuntimeException("Linked list is empty");
            }
            Node temp = head;
            do {
                System.out.println(temp);
                temp = temp.next;
            } while (temp != null);
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
