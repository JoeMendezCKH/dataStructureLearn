package cn.joe.d04sortalgorithm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * insertion sort
 * 耗时:
 * 2020-03-09 15:08:37
 * 2020-03-09 15:08:38
 *
 * @author Joe
 * @create 2020/3/9 14:50
 */
public class InsertionSortDemo {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
        int[] arr = ArrayDataUtil.initArrData(80000);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        insertionSort(arr);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // define a wait insert number
            int insertVal = arr[i];
            // before insertVal's site index
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSortDemo(int[] arr) {
        // first sort
        // {104, 34, 119, 1}--> {34, 104, 119, 1}
        int insertVal = arr[1];
        // before the arr[1]'s index
        int insertIndex = 1 - 1;

        // find the location of the insertVal
        // when the insertVal<arr[insertIndex] is true; it's mean that the insertVal doesn't find his site
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            // need move the arr[insertIndex]
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // end the while ==> the site of the insert is the insertIndex+1
        // because the insertIndex primary minus 1, now need to add
        arr[insertIndex+1] = insertVal;
        System.out.println(Arrays.toString(arr));


    }
}
