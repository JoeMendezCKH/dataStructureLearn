package com.joe.beginzero.stackandrecursion.stackbrackets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions
 *
 * @author ckh
 * @create 10/26/20 4:39 PM
 */
public class ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();

        // 第一个log必然是开始,初始化栈
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);

        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if ("start".equals(s[1])) {
                if (!stack.isEmpty()) {
                    // 新的函数开始, 则旧函数暂停, 用时 = 原有耗时 + 新的函数开始时间 - 前一个函数开始时间
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                // 正在执行的函数入栈
                stack.push(Integer.parseInt(s[0]));
                // 更新下一个开始时间, 因为是start, 所以就是该值
                prev = Integer.parseInt(s[2]);
            } else {
                // end 结束栈顶函数运行, 耗时 = 之前耗时 + 结束时间 - 前一个开始时间 + 1
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                // 弹出栈顶函数
                stack.pop();
                // 更新下一个开始时间, 因为是end, 开始时间需要+1
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] exclusiveTime = new ExclusiveTimeFunctions().exclusiveTime(3,
                Arrays.asList("0:start:0", "1:start:2", "1:end:5", "2:start:6", "2:end:9", "0:end:12"));
        System.out.println(Arrays.toString(exclusiveTime));

    }
}
