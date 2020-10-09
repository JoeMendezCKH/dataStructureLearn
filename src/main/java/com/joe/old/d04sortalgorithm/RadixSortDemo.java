package com.joe.old.d04sortalgorithm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 基数排序:
 *      速度很快, 但是占用空间太大, 80000000时引发 OOM
 * @author Joe
 * @create 2020/3/19 13:27
 */
public class RadixSortDemo {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
        int[] arr = ArrayDataUtil.initArrData(8000000);

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        radixSort(arr);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        // 得到最大位数
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                // 获取对应位数
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照桶的顺序, 取出值放回原来的数组
            int index = 0;
            // 遍历每个桶
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据, 则放入
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                // 将bucketElementCounts[i] 置零!!!!!!!!!!!!!
                bucketElementCounts[k] = 0;
            }

        }


    }

    private static void radixSortProcess(int[] arr) {
        // 第一轮排序
        // 定义一个二维数组, 表示10个桶, 防止数据溢出, 每个桶的大小放大
        // 空间换时间
        int[][] bucket = new int[10][arr.length];
        // 记录每个桶中实际存放的数据, 该数组的索引对应着某个桶, 值对应桶中的数据个数
        // 即 bucketElementCounts[2] = 4;  表示第2个桶中有 4 个数据
        int[] bucketElementCounts = new int[10];

        for (int j = 0; j < arr.length; j++) {
            // 获取个位数
            int digitOfElement = arr[j] % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照桶的顺序, 取出值放回原来的数组
        int index = 0;
        // 遍历每个桶
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据, 则放入
            if (bucketElementCounts[k] != 0) {
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            // 将bucketElementCounts[i] 置零!!!!!!!!!!!!!
            bucketElementCounts[k] = 0;
        }
        System.out.println(Arrays.toString(arr));

        for (int j = 0; j < arr.length; j++) {
            // 获取十位数
            int digitOfElement = arr[j] / 10 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照桶的顺序, 取出值放回原来的数组
        index = 0;
        // 遍历每个桶
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据, 则放入
            if (bucketElementCounts[k] != 0) {
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println(Arrays.toString(arr));

        for (int j = 0; j < arr.length; j++) {
            // 获取百位数
            int digitOfElement = arr[j] / 100 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照桶的顺序, 取出值放回原来的数组
        index = 0;
        // 遍历每个桶
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据, 则放入
            if (bucketElementCounts[k] != 0) {
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

}
