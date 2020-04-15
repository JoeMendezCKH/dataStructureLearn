package ck.ckh.day03stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


/**
 * sample int number calculator
 *
 * @author Joe
 * @create 2019/10/17 14:58
 */
@SuppressWarnings({"AlibabaRemoveCommentedCode", "AlibabaUndefineMagicConstant"})
public class PolandNotation {
    public static void main(String[] args) {
        // 先定义逆波兰表达式  3 4 + 5 * 6 -   ==>  (3+4)*5-6
        // 4*5-8+60+8/2 ==> 4 5 * 8 - 60 + 8 2 / +
        // 为了方便, 每个符号间用空格隔开
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";

        /*List<String> rpnList = getListString(suffixExpression);
        System.out.print(rpnList + "= ");
        int res = cal(rpnList);
        System.out.println(res);*/
//        =================================================


//        思路:
//            1. 先将(3+4) * 5 -6放入 array list中
//            2. 将ArrayList传递给一个方法,  配合栈完成


        String expression = "1+((2+3)*4)-5";
        Scanner in = new Scanner(System.in);
        System.out.println("please enter a string: ");
        String s = in.nextLine();
        List<String> strings = toInfixExpressList(s);
        // System.out.println(strings);s
        List<String> strings1 = parseSuffixExpressionList(strings);
        //  System.out.println(strings1);s
        int cal = cal(strings1);
        System.out.println(s + " = " + cal);

    }

    /**
     * 将逆波兰表达式放入array list中
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        String[] strings = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String string : strings) {
            list.add(string);
        }
        return list;
    }

    /**
     * 实现对逆波兰表达式的计算
     */
    public static int cal(List<String> ls) {
        Stack<String> stack = new Stack<>();
        int res = 0;
        for (String item : ls) {
            // 使用正则来取出数字
            if (item.matches("\\d+")) {
                // 匹配多位数
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("wrong signs");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }


    /**
     * 将中缀表达式转换为对应的List
     *
     * @param expression 中缀表达式
     * @return 对应的List
     */
    public static List<String> toInfixExpressList(String expression) {
        // 定义一个List, 存放中缀表达式
        List<String> ls = new ArrayList<>();
        // 用于遍历ls
        int i = 0;
        // 对多位数拼接
        StringBuilder str;
        // 遍历一个字符, 就放入到c
        char c;
        do {
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {
                // '0' 48  '9' 57
                ls.add("" + c);
                i++;
            } else {
                str = new StringBuilder();
                while (i < expression.length() && (c = expression.charAt(i)) >= 48 && (c = expression.charAt(i)) <= 57) {
                    str.append(c);
                    i++;
                }
                ls.add(str.toString());
            }
        } while (i < expression.length());
        return ls;
    }


    /**
     * 将中缀表达式转换为逆波兰表达式
     * 思路:
     * 1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
     * 2) 从左至右扫描中缀表达式；
     * 3) 遇到操作数时，将其压s2；
     * 4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
     * 1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     * 2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
     * 3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
     * 5) 遇到括号时：
     * (1) 如果是左括号“(”，则直接压入s1
     * (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
     * 6) 重复步骤2至5，直到表达式的最右边
     * 7) 将s1中剩余的运算符依次弹出并压入s2
     * 8) 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     *
     * @param ls 中缀表达式对应的List集合
     * @return 逆波兰表达式的集合
     */
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 符号栈
        Stack<String> s1 = new Stack<>();
        // 因为s2栈 在整个过程中没有pop操作, 而且后面还要逆序输出, 所以就用List写 , 用list存储结果
        List<String> s2 = new ArrayList<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                // 数字直接入s2
                s2.add(item);
            } else if ("(".equals(item)) {
                s1.push(item);
            } else if (")".equals(item)) {
                // 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                // 弹出 (
                s1.pop();
            } else {
                // 当s1
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
