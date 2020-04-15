package ck.ckh.d04sortalgorithm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * BubbleSort   时间复杂度: O(n^2)
 * 耗时:
 *     begin time 2020-03-09 14:19:53
 *     after time 2020-03-09 14:20:09
 *
 * @author Joe
 * @create 2020/3/9 13:44
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
//        int[] arr = {112,3, 9, -1, 10, -2};
        int[] arr = ArrayDataUtil.initArrData(80000);
        System.out.println("begin time : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        optimizationBubble(arr);

        System.out.println("after time : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }

    private static void optimizationBubble(int[] arr) {
        // 标识此次遍历中是否发生交换
        boolean flag = false;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    private static void normalBubble(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}