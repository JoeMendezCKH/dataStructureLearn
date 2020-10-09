package com.joe.datastructure.part7;

import com.joe.old.d04sortalgorithm.ArrayDataUtil;
import com.sun.javafx.scene.control.behavior.TextInputControlBehavior;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @author ckh
 * @create 10/9/20 11:23 AM
 */
public class SortTest {

    Integer[] a;

    /**
     * 因为是 对象数组， 所以较纯数字慢一点
     * heapSort: 10 s
     * mergeSort: 3~4 s
     */
    @Test
    public void testHeap() {
        Integer[] a = {4, 6, 5, 2, 1, 3, 9, 8};
//        SortAlgorithm.heapSort(a);

        SortAlgorithm.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testSort() {
        Integer[] a = ArrayDataUtil.initIntegerArr(8000000);
        System.out.println("begin: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        SortAlgorithm.mergeSort(a);
        System.out.println("end: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

}
