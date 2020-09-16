package com.joe.janzhi;

/**
 * Offer 05. 替换空格
 *
 * @author ckh
 * @create 9/16/2020 8:21 PM
 */
public class ReplaceSpace05 {

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c!=' '){
                stringBuilder.append(c);
            } else {
                stringBuilder.append("%20");
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        String str = "hello word asd fas";
        ReplaceSpace05 replaceSpace05 = new ReplaceSpace05();
        System.out.println(replaceSpace05.replaceSpace(str));

    }
}
