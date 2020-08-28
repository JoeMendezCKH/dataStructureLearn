package com.joe.beginzero.strings.transfernumandstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. Relative Ranks
 *
 * @author ckh
 * @create 8/28/20 2:50 PM
 */
public class RelativeRanks {
    public static String[] findRelativeRanks(int[] nums) {
        int len = nums.length;

        int[] temp = nums.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>(len);

        // put the location of the nums
        for (int i = 0; i < len; i++) {
            map.put(temp[i], i);
        }

        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            int index = map.get(nums[i]);
            if (index == len - 1) {
                res[i] = "Gold Medal";
            } else if (index == len - 2) {
                res[i] = "Silver Medal";
            } else if (index == len - 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = String.valueOf(len - index);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1, 34, 12, 42};
        System.out.println(Arrays.toString(findRelativeRanks(nums)));
    }
}
