package com.joe.beginzero.array.countnums;

import java.util.*;

/**
 * 645 (今天状态不好, 就写一道 -_-!)
 *
 * @author ckh
 * @create 2020/7/19 16:38
 */
public class SetMisMatch {

    /**
     * 位运算, 异或
     * 3ms  太秀了
     */
    public static int[] method5(int[] nums) {
        int xor = 0, xor0 = 0, xor1 = 0;

        for (int n : nums) {
            xor ^= n;
        }

        for (int i = 1; i <= nums.length; i++) {
            xor ^= i;
        }
        /*
            此时的 xor 中是 重复元素 ^ 缺失元素,  因为其他的都配对抵消了
            然后需要的是找到 xor 中第一位不同的位, 比如 xor = 0B0111 , 表示最低位就不同了
            如果 xor = 0B0110 表示从第 2 位起不同
            然后 根据该位, 将所有的元素分为 2 类, 比如从第1位起不同, 则分为 xxx0 和 xxx1 2 类
            重复元素和缺失元素分别在这 2 类中,
            重复元素组中, 有一类相同的元素的个数为 3, 有 2 个是本来2组中该有的, 多出来的那个就是重复的
            缺失元素组中, 有一类元素只有1个, 该元素就是缺失的, 如果忘记了 在纸上写一下就明白了

            所以, 对 2 类元素进行异或, 留下的结果就是那 2 个元素
            在数组中遍历一遍, 存在的就是重复的, 不存在就是缺失的

         */

        System.out.println(Integer.toBinaryString(xor));
        System.out.println(Integer.toBinaryString(-xor));
        System.out.println(Integer.toBinaryString(~(xor - 1)));

        // 得到最右边的 1 的那一位
        int rightMostBit = xor & ~(xor - 1);

        for (int n : nums) {
            if ((n & rightMostBit) != 0) {
                xor1 ^= n;
            } else {
                xor0 ^= n;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((i & rightMostBit) != 0) {
                xor1 ^= i;
            } else {
                xor0 ^= i;
            }
        }
        for (int num : nums) {
            if (num == xor0) {
                return new int[]{xor0, xor1};
            }
        }
        return new int[]{xor1, xor0};
    }

    /**
     * 使用 map, 存储每个数字出现的次数,
     * 如果没有 key 表示缺失, 如果 value > 1, 表示重复
     * <p>
     * 18ms 19%  ≧ ﹏ ≦
     */
    public static int[] method4(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        int dup = -1, missing = 1;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                missing = i;
            }
        }
        return new int[]{dup, missing};
    }

    /**
     * 先排序, 然后就方便寻找重复和缺失的了
     * 11ms 42%
     */
    public static int[] method3(int[] nums) {
        Arrays.sort(nums);
        /*
        missing = 1 不是随便写的
        因为题目说了, 从 1 - n , 如果是 2,2 的话, 缺失值是 1
         */
        int dup = -1, missing = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dup = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }
        }

        //  return new int[]{dup, missing};  只有2个元素时, 这样missing不会被赋值, 是默认值
        //  而且还要保证 2, 2 可以满足输出, 所以 missing 初始化为 1
        //  下面写成 nums[nums.length - 1] != nums.length ? nums.length :  missing 这样
        return new int[]{dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }


    /**
     * 利用 hashSet 找出重复值, 然后用数学公式算出来
     * 10 ms 45%
     */

    public static int[] method2(int[] nums) {
        int[] result = new int[2];
        int numsSum = 0;

        Set set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                // 重复的数
                result[0] = num;
            }
            numsSum += num;
        }

        // 没有重复的和
        int sum = (1 + nums.length) * nums.length / 2;

        // 差值
        int c = sum - numsSum;
        // 缺失的数
        result[1] = result[0] + c;

        return result;
    }

    /**
     * 暴力法
     * 因为题目说了是 1 ~ n 的数字
     * 所以每次遍历所有的元素, 计数,
     *
     * @param nums 给定的集合数组, 有 1 位重复, 1 位丢失
     * @return 返回丢失和重复的2个数
     */
    public static int[] findErrorNums1(int[] nums) {
        int dup = -1, missing = -1;
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (num == i) {
                    count++;
                }
            }
            if (count == 2) {
                dup = i;
            } else if (count == 0) {
                missing = i;
            }
            if (dup > 0 && missing > 0) {
                break;
            }
        }
        return new int[]{dup, missing};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(method5(new int[]{1, 2, 4, 4, 5})));
    }

}
