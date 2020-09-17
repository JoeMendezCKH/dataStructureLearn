package com.joe.janzhi;

import java.util.Stack;

/**
 * Offer 09. 用两个栈实现队列
 *
 * @author ckh
 * @create 9/17/20 2:36 PM
 */
public class CQueue09 {
    Stack<Integer> A, B;

    public CQueue09() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void appendTail(int value) {
        A.push(value);
    }

    public int deleteHead() {
        if (B.empty()) {
            if (A.empty()) {
                return -1;
            }
            while (!A.empty()) {
                B.push(A.pop());
            }
        }
        return B.pop();
    }
}
