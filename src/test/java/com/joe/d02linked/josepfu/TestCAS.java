package com.joe.d02linked.josepfu;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * @author Joe
 * @create 2020/3/22 17:38
 */
public  class TestCAS {

    public static void main(String[] args) {
//        int num = 1;
//        for (int i = 0; i < 3; i++) {
//            num++;
//            System.out.println("num = " + num);
//        }

        String regex = "login";
        String string = "/doctor/login";
        System.out.println(StringUtils.contains(string, regex));

        final AES AES_ALGORITHM = SecureUtil.aes(SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded());
        System.out.println("SymmetricAlgorithm.AES.getValue() = " + SymmetricAlgorithm.AES.getValue());
        System.out.println(Arrays.toString(SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded()));
        SecureUtil.aes(new byte[]{52, -125, 79, 77, -1, -77, 13, 127, -128, -119, -20, 22, 122, 1, 113, 1, 23, 123, 111, -23, 3, 4, 84, 8, -10, 55, -103, 102, -77, -103, -50, 54, 15});
    }

    @Test
    public void test1() {

        int num = Integer.MAX_VALUE;
        long temp = num + 2L;
        String s = "asdfas";
        int d = s.indexOf('d');
        System.out.println("d = " + d);
        System.out.println(num);
    }

    private static int info(int x, double y) {
        return -1;
    }

    private static int info(int x, int y) {
        return -1;
    }
}
