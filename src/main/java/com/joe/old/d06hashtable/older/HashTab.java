package com.joe.old.d06hashtable.older;

/**
 * 哈希表类, 管理多条链表
 * Created by Mendez on 19/10/29 16:09
 *
 * @author Joe
 */
public class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    /**
     * 有多少条链表
     */
    private int size;


    public HashTab(int size) {
        this.size = size;
        // 初始化
        empLinkedListArray = new EmpLinkedList[size];

        // 不要忘了分别初始化每个链表!!!!!!!!!!!!!
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }


    public void add(Emp emp) {
        // 根据员工id得到该员工应当添加到哪一条链表
        int empLinkedNo = hashFun(emp.id);
        empLinkedListArray[empLinkedNo].add(emp);
    }

    /**
     * 遍历哈希表(数组+链表)
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.print("No " + (i + 1) + "'s ");
            empLinkedListArray[i].list();
        }
    }

    /**
     * 查找
     */
    public void findEmpById(int id) {
        // 判断在哪一条链表中找
        int empLinkedNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedNo].findEmpById(id);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("not find");
        }

    }

    /**
     * 编写散列函数
     */
    public int hashFun(int id) {
        return id % size;
    }


}
