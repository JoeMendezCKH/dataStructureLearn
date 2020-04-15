package ck.ckh.day04sortalgorithm;

import sun.security.provider.PolicySpiFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 希尔排序: 避免在简单插入排序中, 一个最小的数在最后面, 要移动n-1次, (在while中一直跑)
 *
 * @author Joe
 * @create 2020/3/18 15:55
 */
public class ShellSortDemo {

    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = ArrayDataUtil.initArrData(8000000);
        System.out.println("begin: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        shellSortByExchange(arr);
        shellSortByMove(arr);
        System.out.println("end: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        String s = String.valueOf(1);
    }

    /**
     * 优化 shell 排序
     * 强烈推荐, 记住!!!!!!!!
     *
     * @param arr
     */
    private static void shellSortByMove(int[] arr) {
        final int size = 2;
        for (int gap = arr.length / size; gap > 0; gap /= size) {
            for (int i = gap; i < arr.length; i++) {
                int insertIndex = i;
                int insertVal = arr[i];
                if (arr[insertIndex - gap] > arr[insertIndex]) {
                    while ((insertIndex - gap) >= 0 && insertVal < arr[insertIndex - gap]) {
                        // move the site
                        arr[insertIndex] = arr[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    // now is sign find the site
                    arr[insertIndex] = insertVal;
                }
            }
        }

//        System.out.println(Arrays.toString(arr));
    }

    private static void shellSortByExchange(int[] arr) {
        final int size = 2;
        int temp = 0;
//        int count = 0;
        for (int gap = arr.length / size; gap > 0; gap /= size) {
            // 每次分为 gap 组, 步长也为 gap, 每次进行插入排序
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            count += 1;
//            System.out.println("shell " + count + "'s: " + Arrays.toString(arr));
        }
    }

    private static void shellSortDemo(int[] arr) {
        // first
        // 第一轮, 将10个数据分为5组
        int temp;
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组中的所有元素(共5组, 每组2个), 步长为5
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        // 第二轮, 将10个数据分为 5/2 == 2 组
        for (int i = 2; i < arr.length; i++) {
            // 遍历各组中的所有元素(共5组, 每组2个), 步长为5
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        // 第三轮, 将10个数据分为 2 / 2 == 1 组
        for (int i = 1; i < arr.length; i++) {
            // 遍历各组中的所有元素(共5组, 每组2个), 步长为5
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
