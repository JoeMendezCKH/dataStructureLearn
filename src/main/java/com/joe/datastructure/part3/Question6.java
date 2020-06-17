package com.joe.datastructure.part3;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Josephus went
 * <p>
 * A basic algorithm is to iterate through the list, removing every Mth item. This can be improved by
 * two observations. The first is that an item M distance away is the same as an item that is only M
 * mod N away. This is useful when M is large enough to cause iteration through the list multiple times.
 * The second is that an item M distance away in the forward direction is the same as an item (M − N)
 * away in the backwards direction. This improvement is useful when M is more than N/2 (half the
 * list). The solution shown below uses these two observations. Note that the list size changes as items
 * are removed. The worst case running time is O(N min(M, N)), though with the improvements given
 * the algorithm might be significantly faster. If M = 1, the algorithm is linear.
 * <p>
 * 可以参考 cn.joe.d02linked.josepfu.CircleSingleLinkedList#showNumber(int, int, int) 方法
 *
 * @author Joe
 * @create 2020/6/17 10:51
 */
public class Question6 {
    public static void pass(int m, int n) {

        int i, j, mPrime, numLeft;
        ArrayList<Integer> list = new ArrayList<>();

        for (i = 1; i <= n; i++) {
            list.add(i);
        }

        ListIterator<Integer> iter = list.listIterator();
        Integer item = 0;
        numLeft = n;
        mPrime = m % n;
        for (i = 0; i < n; i++) {
            mPrime = m % numLeft;
            if (mPrime <= numLeft / 2) {
                if (iter.hasNext()) {
                    item = iter.next();
                }
                for (j = 0; j < mPrime; j++) {
                    if (!iter.hasNext()) {
                        iter = list.listIterator();
                    }
                    item = iter.next();
                }
            } else {
                for (j = 0; j < numLeft - mPrime; j++) {
                    if (!iter.hasPrevious()) {
                        iter = list.listIterator(list.size());
                    }
                    item = iter.previous();
                }
            }
            System.out.print("Removed " + item + " ");
            iter.remove();
            if (!iter.hasNext()) {
                iter = list.listIterator();
            }
            System.out.println();
            for (Integer x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
            numLeft--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        pass(1, 5);
    }
}
