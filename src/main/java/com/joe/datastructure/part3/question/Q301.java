package com.joe.datastructure.part3.question;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 3.1 p67
 *
 * @author ckh
 * @create 10/6/20 2:38 PM
 */
public class Q301 {

    public static <T> void printLots(List<T> L, List<Integer> P) {
        Iterator<T> iteratorL = L.iterator();
        Iterator<Integer> iteratorP = P.iterator();

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
            System.out.println(itemL);
        }
    }

    public static void main(String[] args) {
        printLots(Arrays.asList("a","b","c","d","e"),Arrays.asList(1,3,5));
    }

}
