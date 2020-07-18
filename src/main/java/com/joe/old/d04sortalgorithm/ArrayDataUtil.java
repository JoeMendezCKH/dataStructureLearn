package com.joe.old.d04sortalgorithm;

import java.util.Random;

/**
 * @author Joe
 * @create 2020/3/9 14:02
 */
public class ArrayDataUtil {
    public static int[] initArrData(int size){
        int[] arr = new int[size];
        Random random = new Random(32);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(80000);
        }
        return arr;
    }

}
