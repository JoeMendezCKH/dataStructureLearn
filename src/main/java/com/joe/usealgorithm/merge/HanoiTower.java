package com.joe.usealgorithm.merge;

/**
 * merge algorithm
 *
 * @author Joe
 * @create 2020/4/20 13:50
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("把第 1 个盘从 " + a + " -> " + c);
        } else {
            // 把 n>=2 看作 2个盘, 1. 最下面的一个盘, 2. 上面的所有盘
            // 1. 把上面的所有盘从a->b
            hanoiTower(num - 1, a, c, b);
            // 2. 把最下面盘 从 a->c
            System.out.println("把第 " + num + " 个盘从 " + a + " -> " + c);
            // 3. 把在b上所有的放到c
            hanoiTower(num - 1, b, a, c);
        }
    }

}
