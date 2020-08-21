package com.joe.beginzero.strings.countwords;

import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 *
 * @author ckh
 * @create 2020/8/21 16:30
 */
public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        int[] letters = new int[256];
        // fill the array
        for (char c : s.toCharArray()) {
            letters[c]++;
        }
        // maintain the array sequence's mean to present the letter
        // big top heap, sort the by heap
        PriorityQueue<Letter> queue = new PriorityQueue<>();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                queue.add(new Letter((char) i, letters[i]));
            }
        }
        // traverse the heap, print the letter
        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            Letter latter = queue.poll();
            for (int i = 0; i < latter.count; i++) {
                stringBuilder.append(latter.letter);
            }
        }
        return stringBuilder.toString();
    }

    private static class Letter implements Comparable<Letter> {

        public char letter;
        public int count;
        public Letter(char latter, int count) {
            this.letter = latter;
            this.count = count;
        }

        @Override
        public int compareTo(Letter o) {
            return o.count - this.count;
        }

    }


    public static void main(String[] args) {
        String s = "asdfasdfxczxxzczcvvasdfasdfwefvrjjmrmrj ";
        System.out.println(frequencySort(s));

    }
}
