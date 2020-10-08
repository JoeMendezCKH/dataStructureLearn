package com.joe.datastructure.part3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 列表的删除示例
 *
 * @author ckh
 * @create 9/25/20 9:02 AM
 */
public class RemoveTest {

    /**
     * 对于 ArrayList remove 花费 O(n)
     * 对于 LinkedList get 花费 O(n)
     *
     * @param list
     */
    public static void removeEvensVer1(List<Integer> list) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    /**
     * ConcurrentModificationException
     * 在迭代器遍历期间修改列表值
     *
     * @param list
     */
    public static void removeEvensVer2(List<Integer> list) {
        for (Integer x : list) {
            if (x % 2 == 0) {
                list.remove(x);
            }
        }
    }

    public static void removeEvensVer3(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            if (iterator.next() % 2 == 0){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};

        removeEvensVer3(list);

        System.out.println(list);
    }

}
