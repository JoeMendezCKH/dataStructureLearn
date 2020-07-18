package com.joe.old.d04sortalgorithm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * select sort O(n^2)
 * <p>
 * 耗时:
 *    14:45:13
 *    14:45:16
 *
 * @author Joe
 * @create 2020/3/9 14:28
 */
public class SelectSortDemo {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
        int[] arr = ArrayDataUtil.initArrData(80000);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        SelectSort(arr);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

    }

    private static void SelectSort(int[] arr) {
        // assume the min number index is 0
        int minIndex;
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // put the min at the arr[0] site, that is exchange
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        // System.out.println("arr = " + Arrays.toString(arr));
    }
}
