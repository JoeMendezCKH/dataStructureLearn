package com.joe.beginzero.array.traversalarray;


/**
 * 495,  这题目真是够了
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/teemo-attacking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ckh
 * @create 2020/7/18 10:26
 */
public class TeemoAttacking {


    /**
     * 2ms  99.26%
     * ^_^
     *
     * @param timeSeries 攻击序列
     * @param duration   单次攻击持续时间
     * @return 造成伤害
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        if (timeSeries.length == 1) {
            return duration;
        }

        int hurt = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            int temp = timeSeries[i] - timeSeries[i - 1];
            if (temp >= duration) {
                hurt += duration;
            } else if (temp >= 1) {
                hurt += temp;
            }
        }
        return hurt;
    }

    public static void main(String[] args) {
        int duration = findPoisonedDuration(new int[]{1, 2, 3, 5}, 2);

        System.out.println(duration);
    }
}
