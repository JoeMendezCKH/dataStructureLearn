package com.joe.old.d05search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joe
 * @create 2020/3/19 14:18
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2;
        }
        System.out.println("target index : " + binarySearchMany(arr, 0, arr.length - 1, 40));
    }

    /**
     * 只找一个
     *
     * @param arr   源数组
     * @param left  左边索引
     * @param right 右边索引
     * @param value 查找值
     * @return 目标索引
     */
    private static int binarySearch(int[] arr, int left, int right, int value) {
        System.out.println("asd");
        if (left > right) {
            // 没有找到
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (value > midVal) {
            return binarySearch(arr, mid + 1, right, value);
        } else if (value < midVal) {
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }

    }

    /**
     * 找所有,
     * 找到value后, 不是立刻返回, 向value 索引左,右两边扫描, 找到所有满足条件的下标, 放入集合返回
     *
     * @param arr   源数组
     * @param left  左边索引
     * @param right 右边索引
     * @param value 查找值
     * @return 目标索引
     */
    private static List<Integer> binarySearchMany(int[] arr, int left, int right, int value) {
        System.out.println("asd");
        if (left > right) {
            // 没有找到
            return null;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (value > midVal) {
            return binarySearchMany(arr, mid + 1, right, value);
        } else if (value < midVal) {
            return binarySearchMany(arr, left, mid - 1, value);
        } else {
            List<Integer> results = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == value) {
                results.add(temp);
                temp -= 1;
            }
            results.add(mid);
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == value) {
                results.add(temp);
                temp += 1;
            }
            return results;
        }
    }
}
