package com.joe.datastructure.part3.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author ckh
 * @create 10/6/20 3:28 PM
 */
public class Q304 {

    /**
     * L1 intersect L2
     */
    public static <AnyType extends Comparable<? super AnyType>> List<AnyType> intersection1(List<AnyType> L1,
                                                                                            List<AnyType> L2) {

        List<AnyType> intersect = new ArrayList<>();
        Iterator<AnyType> iteratorL1 = L1.iterator();
        Iterator<AnyType> iteratorL2 = L2.iterator();
        AnyType itemL1 = null, itemL2 = null;
        if (iteratorL1.hasNext() && iteratorL2.hasNext()) {
            itemL1 = iteratorL1.next();
            itemL2 = iteratorL2.next();
        }

        while (itemL1 != null && itemL2 != null) {
            int compare = itemL1.compareTo(itemL2);

            if (compare == 0) {
                intersect.add(itemL1);
                itemL1 = iteratorL1.hasNext() ? iteratorL1.next() : null;
                itemL2 = iteratorL2.hasNext() ? iteratorL2.next() : null;
            } else if (compare < 0) {
                itemL1 = iteratorL1.hasNext() ? iteratorL1.next() : null;
            } else {
                itemL2 = iteratorL2.hasNext() ? iteratorL2.next() : null;
            }
        }
        return intersect;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 45, 56);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 23, 45);
        List<Integer> integers = intersection1(list1, list2);

        System.out.println(integers);
    }
}
