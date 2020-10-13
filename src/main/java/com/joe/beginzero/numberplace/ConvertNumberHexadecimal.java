package com.joe.beginzero.numberplace;

/**
 * 405. Convert a Number to Hexadecimal
 *
 * @author ckh
 * @create 10/12/20 8:56 PM
 */
public class ConvertNumberHexadecimal {

    /**
     * 成功了， 但是有点违反要求， 不能用库函数
     */
    public static String toHex1(int num) {
        if (num == 0) {
            return "0";
        }
        String binary = Integer.toBinaryString(num);
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = binary.toCharArray();

        int sum = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];

            if (count == 1) {
                sum += (c - 48);
            } else if (count == 2) {
                sum += (c - 48) * 2;
            } else if (count == 3) {
                sum += (c - 48) * 4;
            } else if (count == 4) {
                sum += (c - 48) * 8;
                transform(stringBuilder, sum);
                sum = 0;
                count = 0;
            }
            count++;
        }
        if (sum != 0) {
            transform(stringBuilder, sum);
        }
        return stringBuilder.reverse().toString();

    }

    public static void transform(StringBuilder sb, int i) {
        if (i < 10) {
            sb.append(i);
        } else if (i == 10) {
            sb.append("a");
        } else if (i == 11) {
            sb.append("b");
        } else if (i == 12) {
            sb.append("c");
        } else if (i == 13) {
            sb.append("d");
        } else if (i == 14) {
            sb.append("e");
        } else if (i == 15) {
            sb.append("f");
        }
    }

    public String toHex(int num) {
        // 0特殊处理
        if (num == 0) {
            return "0";
        }

        // 获取32位二进制位
        int[] bits = new int[32];
        for (int i = 31; i >= 0; i--) {
            // 获取数字的二进制位，又忘记了，牢记 ！！
            bits[i] = num & 0x1;
            num >>>= 1;
        }
        // 从左到右每4位转成1位十六进制
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= 28; i += 4) {
            int sum = 8 * bits[i] + 4 * bits[i + 1] +
                    2 * bits[i + 2] + 1 * bits[i + 3];
            if (sum <= 9) {
                ans.append((char) (sum + '0'));
            } else if (sum <= 15) {
                ans.append((char) (sum - 10 + 'a'));
            }
        }
        // 去掉前导0，这就是为什么0要特殊处理的原因
        // 因为0的十六进制还是全为0，用这个循环会越界访问
        while (ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        return ans.toString();

    }


    public static String toHexPerfect(int num) {
        // 0特殊处理
        if (num == 0) {
            return "0";
        }
        // 映射关系
        char[] hex = "0123456789abcdef".toCharArray();

        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            // 取低4位的十进制值
            int temp = num & 0xf;
            // 映射对应字符
            ans.append(hex[temp]);

            // 逻辑右移4位
            num >>>= 4;
        }
        // while的循环条件保证了不会出现前导0
        // 但是从低位开始转换多了一步reverse反转
        return ans.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(toHexPerfect(123));
    }
}
