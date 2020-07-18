package com.joe.old.d06hashtable.newer;

import java.util.Scanner;

/**
 * @author Joe
 * @create 2020/4/15 14:39
 */
public class MyHashTableDemo {
    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(7);
        String key = " ";
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Please enter a key: ");
            System.out.println("put: 添加");
            System.out.println("list: 显示");
            System.out.println("get: 查找");
            System.out.println("remove: 删除");
            System.out.println("exit: 退出");
            key = in.next();
            switch (key) {
                case "put":
                    System.out.println("enter the id: ");
                    int id = in.nextInt();
                    System.out.println("enter the data of the node: ");
                    int data = in.nextInt();
                    hashTable.put(id, data);
                    break;
                case "list":
                    try {
                        hashTable.list();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "get":
                    System.out.println("please enter the id: ");
                    id = in.nextInt();
                    hashTable.get(id);
                    break;
                case "remove":
                    System.out.println("please enter the id: ");
                    id = in.nextInt();
                    hashTable.remove(id);
                    break;
                case "exit":
                    in.close();
                    System.out.println("system is exit");
                    break;
                default:
                    System.out.println("wrong keys");
                    break;
            }
            System.out.println("============");
        } while (!"exit".equals(key));
    }
}
