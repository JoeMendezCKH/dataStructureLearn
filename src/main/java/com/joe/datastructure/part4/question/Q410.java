package com.joe.datastructure.part4.question;

import java.io.File;

/**
 * 4.10
 *
 * @author ckh
 * @create 10/7/20 5:15 PM
 */
public class Q410 {

    public void list(File f) {
        list(f, 0);

    }

    private void list(File f, int depth) {
        printName(f, depth);
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                list(file, depth + 1);
            }
        }
    }

    private void printName(File f, int depth) {
        String name = f.getName();
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        if (f.isDirectory()) {
            System.out.println("Dir: " + name);
        } else {
            System.out.println(f.getName() + ":" + f.length());
        }
    }

    public static void main(String[] args) {
//        Q410 list = new Q410();
//        File f = new File("/home/joe/Documents/temp");
//        list.list(f);

        System.out.println(1989 % 7);
    }
}
