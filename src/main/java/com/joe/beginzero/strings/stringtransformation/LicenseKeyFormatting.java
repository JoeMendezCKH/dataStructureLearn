package com.joe.beginzero.strings.stringtransformation;

/**
 * 482. License Key Formatting
 *
 * @author ckh
 * @create 9/13/20 7:59 PM
 */
public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        char[] result = new char[chars.length + S.length() / K];
        int length = 0;
        // 逆序遍历
        int i = chars.length - 1, j = result.length - 1;
        while (i >= 0) {
            if (chars[i] == '-') {
                i--;
                continue;
            }
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
            if (length != K) {
                result[j] = chars[i];
                length++;
                j--;
                if (i == 0) {
                    break;
                } else {
                    i--;
                }
            } else {
                length = 1;
                result[j] = '-';
                result[j - 1] = chars[i];
                j -= 2;
                i--;
            }
        }

        return new String(result, j + 1, result.length - j - 1);

    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
