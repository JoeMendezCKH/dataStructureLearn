package cn.joe.d07tree.application;

import java.util.Arrays;

/**
 * @author Joe
 * @create 2020/4/16 15:25
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * heap sort 大顶堆
     *
     * @param arr target array
     */
    public static void heapSort(int[] arr) {
        int temp = 0;

        // 从最后一个非叶子节点开始调整, 保证是一个严格的大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 交换元素, 达到升序
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }

    /**
     * 将以 index 索引对应的非叶子节点的树调整为大顶堆
     * 公式: index = array.length/2 -1
     * traverse is left -> right, bottom -> top
     *
     * @param arr    target array
     * @param index  非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整, length逐渐减少
     */
    public static void adjustHeap(int[] arr, int index, int length) {
        int temp = arr[index];
        // begin adjust , arr[i] is arr[index]'s left node
        for (int i = (index * 2 + 1); i < length; i = (i * 2 + 1)) {
            // left < right
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        // for 结束后, 已经将以 i 为父节点的树的最大值放在了最顶(局部)
        // index现在指向的是子节点, 或没变, 所以将原来的值赋回去, 要么交换为原来的小值, 要么保持不变
        arr[index] = temp;
    }
}
