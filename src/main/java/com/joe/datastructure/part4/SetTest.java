package com.joe.datastructure.part4;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ckh
 * @create 10/7/20 5:02 PM
 */
public class SetTest {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(new CaseInsensitiveCompare());
        set.add("hello");
        set.add("heLLo");

        System.out.println(set.size());
    }


    static class CaseInsensitiveCompare implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }
}
