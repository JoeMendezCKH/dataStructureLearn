package com.joe.beginzero.numberplace;

import java.util.Arrays;

/**
 * 492. Construct the Rectangle
 *
 * @author ckh
 * @create 10/15/20 9:19 AM
 */
public class ConstructRectangle {
    public static int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);

        while (area % width != 0) {
            width--;
        }
        return new int[]{area / width, width};
    }

    public static void main(String[] args) {
        System.out.println("constructRectangle = " + Arrays.toString(constructRectangle(65)));
    }
}
