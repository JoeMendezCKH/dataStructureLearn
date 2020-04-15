package ck.ckh.day06hashtable;

import java.util.Scanner;

/**
 * Created on 19/10/29 15:52
 * @author Joe
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        // 测试菜单
        String key = " ";
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Please enter a key: ");
            System.out.println("add: 添加");
            System.out.println("list: 显示");
            System.out.println("exit: 退出");
            key = in.next();
            switch (key){
                case "add":
                    System.out.println("enter the id: ");
                    int id = in.nextInt();
                    System.out.println("enter the name of the employee: ");
                    String name = in.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("please enter the id: ");
                    id = in.nextInt();
                    hashTab.findEmpById(id);
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
