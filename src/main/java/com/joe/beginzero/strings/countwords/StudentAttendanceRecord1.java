package com.joe.beginzero.strings.countwords;


/**
 * 551. Student Attendance Record I
 *
 * @author ckh
 * @create 8/24/2020 11:50 AM
 */
public class StudentAttendanceRecord1 {
    public static boolean checkRecord1(String s) {
        int count = 0;
        for (int i = 0; i < s.length() && count < 2; i++) {
            if (s.charAt(i) == 'A') {
                count++;
            }
        }
        return count < 2 && !s.contains("LLL");
    }

    public boolean checkRecord(String s) {
        int a = 0, l = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
                l = 0;
            } else if (s.charAt(i) == 'L') {
                l++;
                if (l > 2) {
                    return false;
                }
            } else {
                l = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord1("AA"));
    }
}
