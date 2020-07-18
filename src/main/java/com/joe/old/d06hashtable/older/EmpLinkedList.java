package com.joe.old.d06hashtable.older;

/**
 * 表示一条链表
 * Created by Mendez on 19/10/29 15:55
 *
 * @author Joe
 */
public class EmpLinkedList {
    /**
     * 头指针, 该链表的head是直接指向第一个Emp
     */
    private Emp head;

    /**
     * 添加雇员
     * <p>
     * 添加雇员时, id 是自增长的, 即id的分配是从小到大
     * 因此将该雇员加入本链表的最后即可
     *
     * @param emp 加入的新雇员
     */
    public void add(Emp emp) {
        // 如果是第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        // 如果不是第一个, 则使用一个辅助指针, 帮助遍历
        Emp temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 此时将加入的节点加入到链表最后
        temp.next = emp;
    }

    public void list() {
        if (head == null) {
            System.out.println("LinkedList is empty!");
            return;
        }
        Emp temp = head;
        System.out.print("linkedList is : ");
        // 1 -- 2 -- 3
        do {
            System.out.printf("=> id = %d, name = %s", temp.id, temp.name);
            temp = temp.next;
        } while (temp != null);
        System.out.println();
    }

    /**
     * 查找
     */
    public Emp findEmpById(int id) {
        if (head == null) {
            return null;
        }
        Emp temp = head;
        while (true) {
            // 找到了
            if (temp.id == id) {
                break;
            }
            temp = temp.next;
            if (temp == null) {
                // 遍历完都没找到
                break;
            }
        }
        return temp;
    }


}
