package com.joe.datastructure.part3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定表L,P, 表包含升序排列的整数
 * printLots(l,p), 将打印L中由P指定位置的元素
 *
 * @author Joe
 * @create 2020/6/17 10:03
 */
public class Question1 {

    public static void main(String[] args) {

        ArrayList<Integer> listL = new ArrayList<>();
        ArrayList<Integer> listP = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            listL.add(i * 3);

        }
        // 测试用
        // System.out.println(listL);

        listP.add(356);
        listP.add(524);
        listP.add(767);

        long startTime = System.currentTimeMillis();
        printLots(listL, listP);
        System.out.println("used " + (System.currentTimeMillis() - startTime) + " ms");
    }

    public static <T> void printLots(List<T> l, List<Integer> p) {
        Iterator<T> iteratorL = l.iterator();
        Iterator<Integer> iteratorP = p.iterator();

        T itemL = null;
        Integer itemP = 0;
        int start = 0;

        while (iteratorL.hasNext() && iteratorP.hasNext()) {
            itemP = iteratorP.next();

            System.out.println("itemP = " + itemP);

            while (start < itemP && iteratorL.hasNext()) {
                start++;
                itemL = iteratorL.next();
            }
            System.out.println("itemL = " + itemL);
        }
    }

}
