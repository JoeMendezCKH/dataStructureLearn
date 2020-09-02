package com.joe.beginzero.strings.transfernumandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * 640. Solve the equation
 *
 * @author ckh
 * @create 9/2/20 8:52 AM
 */
public class SolveTheEquation {

    public String solveEquation(String equation) {
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x : breakIt(lr[0])) {
            if (x.indexOf("x") > -1) {
                lhs += Integer.parseInt(coeff(x));
            } else {
                rhs -= Integer.parseInt(x);
            }
        }
        for (String x : breakIt(lr[1])) {
            if (x.indexOf("x") > -1) {
                lhs -= Integer.parseInt(coeff(x));
            } else {
                rhs += Integer.parseInt(x);
            }
        }
        if (lhs == 0) {
            if (rhs == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + rhs / lhs;
    }

    public String coeff(String x) {
        // +3x -> +3 || 3x -> 3
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9') {
            return x.replace("x", "");
        }
        // +x -> +1 || x -> 1
        return x.replace("x", "1");
    }

    public List<String> breakIt(String s) {
        List<String> res = new ArrayList<>();
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (r.length() > 0) {
                    res.add(r);
                }
                r = "" + s.charAt(i);
            } else {
                r += s.charAt(i);
            }
        }
        res.add(r);
        return res;
    }


    /**
     * good and easy to understand
     */
    public String solveEquation2(String equation) {
        String ret = null;
        try {
            String[] split = equation.split("=");
            String left = split[0];
            String right = split[1];
            int[] leftRet = splitVar(left);
            int[] rightRet = splitVar(right);
            int xNum = leftRet[0] - rightRet[0];
            int constNum = rightRet[1] - leftRet[1];
            if (xNum != 0) {
                return "x=" + constNum / xNum;
            }
            if (constNum == 0) {
                return "Infinite solutions";
            }
            return "No solution";
        } catch (Exception ex) {
            ret =  "No solution";
        }
        return ret;
    }

    int[] splitVar(String str) {
        String[] split = str.replace("-", "+-").split("\\+");
        int sumX = 0;
        int sumS = 0;
        for (String s : split) {
            if (s.equals("x")) {
                sumX++;
            } else if (s.equals("-x")) {
                sumX--;
            } else if (s.contains("x")) {
                sumX += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                sumS += Integer.parseInt(s);
            }
        }
        return new int[]{sumX, sumS};
    }



    public static void main(String[] args) {
        String s = "x+5-3+x=6+3x-2";
        String solveEquation = new SolveTheEquation().solveEquation2(s);

        System.out.println("solveEquation : " + solveEquation);
    }

}
