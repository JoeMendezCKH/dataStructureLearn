package com.joe.old.d04sortalgorithm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Joe
 * @create 2020/3/19 11:02
 */
public class MergeSortDemo {
    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] arr = ArrayDataUtil.initArrData(80000000);
//        int[] temp = new int[arr.length];
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        mergeSort(arr, 0, arr.length - 1, temp);
        sortArray(arr);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分+合
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左, 右递归分解
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, right, mid, temp);
        }
    }

    /**
     * 合并
     *
     * @param arr   原始数组
     * @param left  左边有序序列的初始索引
     * @param right 右边索引
     * @param mid   中间索引
     * @param temp  中转数组
     */
    private static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        // 左边有序序列的初始索引
        int leftIndex = left;
        // 右边有序序列的初始索引
        int rightIndex = mid + 1;
        // temp 的索引
        int tempIndex = 0;

        // 1.先把左右两边(有序)的数据按照规则填充到temp中; 直到左右两边有一边处理完毕为止
        while (leftIndex <= mid && rightIndex <= right) {
            // 哪边的元素小, 就将小的元素拷贝到temp中, 并移位
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[tempIndex] = arr[leftIndex];
                tempIndex += 1;
                leftIndex += 1;
            } else {
                temp[tempIndex] = arr[rightIndex];
                tempIndex += 1;
                rightIndex += 1;
            }
        }

        // 2. 将有剩余数据的一边的数据全部填充到temp
        while (leftIndex <= mid) {
            temp[tempIndex] = arr[leftIndex];
            tempIndex += 1;
            leftIndex += 1;
        }
        while (rightIndex <= right) {
            temp[tempIndex] = arr[rightIndex];
            rightIndex += 1;
            tempIndex += 1;
        }

        // 3. 将temp数组拷到 arr, 不是每次都拷贝所有
        tempIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[tempIndex];
            tempIndex += 1;
            tempLeft += 1;
        }
    }

    /** 力扣刷题看到的 80000000 都只要1s, 太强了 ,但是再多一个0会报OOM */
    private static void sortArray(int[] nums){
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            } else if (max < nums[i]) {
                max = nums[i];
            }
        }
        int range = max - min + 1;

        int[] counts = new int[range];
        for (int num : nums) {
            counts[num - min]++;
        }
        for (int i = 0, j = 0; i < range; i++) {
            while (counts[i]-- > 0) {
                nums[j++] = i + min;
            }
        }
    }
}
