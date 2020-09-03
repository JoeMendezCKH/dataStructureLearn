package com.joe.beginzero.strings.subsequence;

import java.util.Arrays;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 *
 * @author ckh
 * @create 9/3/20 8:54 AM
 */
public class LongestWordDictionaryDeleting {

    // failed
    /*
    public String findLongestWord(String s, List<String> d) {
        int max = 0;
        int[] res = new int[d.size()];
        for (int i = 0; i < d.size(); i++) {
            String str = d.get(i);
//            int subsequence = isSubsequence(str, s);
//            max = Math.max(max, subsequence);
            res[i] = isSubsequence(str,s);
        }
        System.out.println(Arrays.toString(res));
        if (max == 0) {
            return StringUtils.EMPTY;
        }
        for (int i = res.length - 1; i > 0; i--) {
            if (res[i] != res[i-1]){
                return d.get(i);
            }
        }
        return d.get(0);
    }



    public int isSubsequence(String s, String t) {
        int index = -1;
        int count = 0;
        for (char c : s.toCharArray()) {
            // index表示上一次查找的位置(第一次查找的时候为-1)，所以这里要从t的下标(index+1)开始查找
            index = t.indexOf(c, index + 1);
            // 找到了
            if (index != -1) {
                count++;
            }
        }
        return count;
    }

    */

    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (x.charAt(j) == y.charAt(i)) {
                j++;
            }
        }
        return j == x.length();
    }

    public String findLongestWordNeedSort(String s, List<String> d) {
        // 先排序， 然后判断是否为子序列
        d.sort((s1, s2) -> s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2));

        for (String str : d) {
            if (isSubsequence(str, s)) {
                return str;
            }
        }
        return "";
    }

    public String findLongestWordNosort(String s, List<String> d) {
        String max_str = "";
        for (String str: d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0)) {
                    max_str = str;
                }
            }
        }
        return max_str;
    }

    public static void main(String[] args) {
        LongestWordDictionaryDeleting deleting = new LongestWordDictionaryDeleting();
        String str = "bab";
        List<String> d = Arrays.asList("ba", "ab", "c", "e");

        System.out.println(deleting.findLongestWordNeedSort(str, d));
    }
}
