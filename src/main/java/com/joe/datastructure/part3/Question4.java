package com.joe.datastructure.part3;

import java.util.Iterator;
import java.util.List;

/**
 * 给定 2 个已排序的表 L1, L2, 使用基本表操作完成交集
 *
 * @author Joe
 * @create 2020/6/17 10:51
 */
public class Question4 {
    public static <AnyType extends Comparable<? super AnyType>>
    void intersection(List<AnyType> l1, List<AnyType> l2, List<AnyType> intersect) {
        Iterator<AnyType> iterator1 = l1.iterator();
        Iterator<AnyType> iterator2 = l2.iterator();

        AnyType item1 = null, item2 = null;

        // get first item in each list
        if (iterator1.hasNext() && iterator2.hasNext()) {
            item1 = iterator1.next();
            item2 = iterator2.next();
        }
        while (item1 != null && item2 != null) {
            int compareResult = item1.compareTo(item2);
            if (compareResult == 0) {
                intersect.add(item1);
                item1 = iterator1.hasNext() ? iterator1.next() : null;
                item2 = iterator2.hasNext() ? iterator2.next() : null;
            } else if (compareResult < 0) {
                item1 = iterator1.hasNext() ? iterator1.next() : null;
            } else {
                item2 = iterator2.hasNext() ? iterator2.next() : null;
            }
        }
    }
}
