package cn.joe.d05search;

import java.util.Arrays;

/**
 * 斐波那契查找 : 每次选取特定位置的值进行比较, 最终找到目标值
 *
 * @author Joe
 * @create 2020/3/19 15:15
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        int key = 8;
        int result = fibonacciSearch(arr, key);
        System.out.println("index: " + result);

    }

    /**
     * 非递归方法得到斐波那契数列
     */
    private static int[] fibonacci(int size) {
        int[] f = new int[size];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < size; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找方法
     * <p>
     * mid = low + f[k-1] -1
     * 1,1,2,3,5,8,13,21,34,55...
     * 目的是让有序数组arr的长度小于f[k], 也就是斐波那契数列的一个值, 比如f[k]=21
     * <p>
     * index: f[k] - 1 = (f[k-1] -1) + (f[k-2]-1) + 1
     * ==>  21 - 1 = (13-1)+ (8-1) +1
     * 数组长度为 n,  n = f[k] - 1;  是为了格式上的统一，以方便递归或者循环程序的编写
     * <p>
     * 数组长20:  index为:  0   1 2 3 4 5 6 7 8 9 10    11         12        13  14 15 16 17 18    19
     *                   low                        f[k-1]-1个               此后有f[k-2]-1个      high
     *                                                           mid
     * 然后将arr数组的长度填充到 f[k] 的长度, index 的范围为 f[k]-1
     * 此时可以将arr分为2个部分, 前 (f[k-1] - 1 = 12) 个, 后(f[k-2] = 8) 个 ,
     * 此时中间的值的索引就为f[k-1] -1, 以这个值为mid , 把数组分成了2部分
     * <p>
     * 每次选取特定位置的值进行比较, 最终找到目标值
     *
     * @param arr 目标数组
     * @param key 目标值
     * @return 找到则返回索引, 找不到返回-1
     */
    private static int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        // arr数组的最大下标
        int high = arr.length - 1;
        // 斐波那契数列分割数值的下标
        int k = 0;
        int mid = 0;
        int[] f = fibonacci(maxSize);

        // 获取斐波那契数列分割值的下标
        while (high > f[k] - 1) {
            k++;
        }
        // 因为f[k]值大于arr, 填充其,此时是用0填充, 但是,是要用arr[high]的值填充
        int[] temp = Arrays.copyOf(arr, f[k] - 1);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                /*
                k--解释:
                    全部元素 = 前面 + 后面, 继续拆分
                    左边有f[k-1] 个,  f[k-1] = f[k-2] + f[k-3]
                    下次进入循环时 mid  = low + f[k-1 -1] -1
                 */
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                /*
                k -= 2解释:
                    右边有f[k-2] 个,  f[k-2] = f[k-3] + f[k-4]
                    下次进入循环时 mid  = low + f[k-1 -2] -1
                 */
                k -= 2;
            } else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }
}
