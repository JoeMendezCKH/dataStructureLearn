package com.joe.beginzero.strings.countwords;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * @author ckh
 * @create 8/20/20 3:45 PM
 */
public class GroupAnagrams {

    /**
     * ordinary mapping
     */
    public static List<List<String>> groupAnagrams1(String[] strings) {
        if (strings == null || strings.length == 0) {
            return Collections.emptyList();
        }
        // mapping relations, "are" -> {"are", "ear", "rea"}
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            // make all words with a same sequence
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    /**
     * 算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，而且这些质因子按大小排列之后，写法仅有一种方式
     * <p>
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
     * 来源：力扣（LeetCode）
     */
    private static final int[] PRIME_NUM = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public  static List<List<String>> groupAnagrams2(String[] strs) {
        // result mapping
        List<List<String>> ans = new ArrayList<>();

        // 该数组中存放的是每个字符通过质数相乘得到的结果，作为key，但是这里可能出现溢出
        Integer[] interestSum = new Integer[strs.length];

        char[][] chars = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            chars[i] = strs[i].toCharArray();
            interestSum[i] = interestSum(chars[i]);
        }

        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < interestSum.length; i++) {
            if (map.containsKey(interestSum[i])) {
                map.get(interestSum[i]).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(interestSum[i], list);

                ans.add(list);
            }
        }
        return ans;
    }

    /**
     * 每个字母对应一个质数, 累乘得到 key
     */
    public static Integer interestSum(char[] chars) {
        int ret = 1;
        for (char c : chars) {
            ret *= PRIME_NUM[c - 'a'];
        }
        return ret;
    }


    public static void main(String[] args) {

        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(strings));


    }
}
