package com.joe.beginzero.stackandrecursion.stackaccesselement;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 682. Baseball Game
 *
 * @author ckh
 * @create 10/20/20 3:17 PM
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Deque<Integer> store = new ArrayDeque<>();
        for (String str : ops) {
            switch (str) {
                case "D":
                    store.push(2 * store.peek());
                    break;
                case "C":
                    store.pop();
                    break;
                case "+":
                    Integer top = store.pop();
                    Integer before = store.peek();
                    store.push(top);
                    store.push(top + before);
                    break;
                default:
                    store.push(Integer.valueOf(str));
                    break;
            }
        }

        int ans = 0;
        while (!store.isEmpty()) {
            ans += store.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BaseballGame().calPoints(new String[]{
                "5", "-2", "4", "C", "D", "9", "+", "+"
        }));
    }
}
