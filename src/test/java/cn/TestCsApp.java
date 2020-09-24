package cn;

import com.joe.usealgorithm.merge.HanoiTower;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author ckh
 * @create 2020/8/11 10:33
 */
public class TestCsApp {

    @Test
    public void testBit() {
        int num = -0b10010101;
        System.out.println(55);
        System.out.println(Integer.toBinaryString(55));
        System.out.println(Integer.toBinaryString(num << 4));
        System.out.println(Integer.toBinaryString(num >> 4));
        System.out.println(Integer.toBinaryString(num >>> 4));


        int x = 0xffff;
        System.out.println(x * x);

        // 补码乘法， 乘以常数 ！！！
        System.out.println((0xff << 8) - 0xff);
    }


    @Test
    public void test02(){
        System.out.println("1"+"\r"+" 2");
    }


}
