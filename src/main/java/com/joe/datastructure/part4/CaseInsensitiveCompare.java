package com.joe.datastructure.part4;

import java.util.Comparator;

/**
 * 伸展树 当一个节点被访问后, 就经过一系列AVL树的旋转被推到根上
 *
 *
 * @author Joe
 * @create 2020/7/4 14:56
 */
public class CaseInsensitiveCompare implements Comparator<String> {
    @Override
    public int compare(String lhs, String rhs) {
        return lhs.compareToIgnoreCase(rhs);
    }
}
