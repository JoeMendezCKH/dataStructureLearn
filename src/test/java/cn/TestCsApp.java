package cn;

import org.junit.Test;

/**
 * @author ckh
 * @create 2020/8/11 10:33
 */
public class TestCsApp {
 
    @Test
    public void testbit(){
        System.out.println(Integer.toBinaryString(-121));
        System.out.println(Integer.toBinaryString(-121 << 4));
        System.out.println(Integer.toBinaryString(-121 >> 4));
        System.out.println(Integer.toBinaryString(-121 >>> 4));
    }
}
