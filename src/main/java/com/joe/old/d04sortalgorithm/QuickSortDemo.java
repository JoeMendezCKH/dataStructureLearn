package com.joe.old.d04sortalgorithm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @author Joe
 * @create 2020/3/19 9:02
 */
public class QuickSortDemo {
    public static void main(String[] args) {

        int[] arr = ArrayDataUtil.initArrData(8000000);
//        int[] arr = {7, 2, 6, 5, 4, 11, 8, 5, 3, 5, 1, 9, 5};
//        System.out.println(Arrays.toString(arr));
//        System.out.println((arr.length-1)/2);
        System.out.println("=========");
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        quickSortV1(arr, 0, arr.length - 1);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("=========");
    }

    /**
     * 尚硅谷版, 好用, 不好理解
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSortV1(int[] arr, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        // 中轴值
        int pivot = arr[(leftIndex + rightIndex) / 2];
        int temp;
        // 让比 pivot 小的 放到左边, 比pivot大的放到右边
        while (leftIndex < rightIndex) {
            // 在 pivot 左边找到大于等于pivot的值
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            // 在 pivot 右边找到小于等于pivot的值
            while (pivot < arr[rightIndex]) {
                rightIndex--;
            }
            // 此时 pivot 左右两边的值已经按照左边全部是小于等于pivot的值, 右边都是大于等于pivot的值
            if (leftIndex >= rightIndex) {
                break;
            }
            // 此处, 当前的arr[leftIndex] 是比 pivot 大的, arr[rightIndex] 是比 pivot 小的, 交换
            temp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = temp;

            // 重点理解这里
            // 若交换完发现arr[rightIndex] or arr[leftIndex] == pivot
            // 左边与右边不用交换, 不然就是把中轴换了, 所以就移动一下对应反向的指针
            if (arr[leftIndex] == pivot) {
                rightIndex--;
            }
            if (arr[rightIndex] == pivot) {
                leftIndex++;
            }
        }
        // 如果 leftIndex==rightIndex , 必须处理, 否则会栈溢出
        if (leftIndex == rightIndex) {
            leftIndex += 1;
            rightIndex -= 1;
        }
        // 向左递归
        if (left < rightIndex) {
            quickSortV1(arr, left, rightIndex);
        }
        // 向右递归
        if (right > leftIndex) {
            quickSortV1(arr, leftIndex, right);
        }
    }

    /**
     * 网上找的, 好理解, 该方法的基本思想是：
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSortV2(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1) {
            return;
        }
        int mid = partition(arr, left, right);
        quickSortV2(arr, left, mid);
        quickSortV2(arr, mid + 1, right);
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (temp <= arr[right] && left < right) {
                --right;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 现在是 arr[right] 需要填坑了
            while (temp >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = temp;
        return left;
    }
}
