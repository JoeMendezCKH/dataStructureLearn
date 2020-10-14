package com.joe.beginzero.numberplace;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 670. Maximum Swap
 *
 * @author ckh
 * @create 10/13/20 10:15 PM
 */
public class MaximumSwap {
    /**
     * bug
     */
    public static int maximumSwap(int num) {

        int[] arr = new int[9];
        int max = 0, length = 0, maxIndex = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (num == 0) {
                break;
            }
            arr[i] = num % 10;
            max = Math.max(arr[i], max);
            if (max == arr[i]) {
                maxIndex = i;
            }
            num /= 10;
            length++;
        }

        int[] temp = Arrays.copyOfRange(arr, arr.length - length, arr.length);
        Arrays.sort(temp);

        System.out.println("temp = " + Arrays.toString(temp));


        // 这里有问题.........

        if (arr[arr.length - length] < max) {
            arr[maxIndex] = arr[arr.length - length];
            arr[arr.length - length] = max;
        }

        for (int i = 0; i < temp.length; i++) {

        }

        System.out.println(Arrays.toString(arr));

        int ans = 0, p = 1;
        for (int i = 0; i < length; i++) {
            ans += p * arr[arr.length - 1 - i];
            p *= 10;
        }

//        System.out.println(ans);

        return ans;
    }

    public static int maximumSwap2(int num) {
        char[] charArray = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < charArray.length; i++) {
            last[charArray[i] - '0'] = i;
        }

        for (int i = 0; i < charArray.length; i++) {
            for (int d = 9; d > charArray[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = charArray[i];
                    charArray[i] = charArray[last[d]];
                    charArray[last[d]] = tmp;
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {

        System.out.println(maximumSwap(94391));
    }
}
