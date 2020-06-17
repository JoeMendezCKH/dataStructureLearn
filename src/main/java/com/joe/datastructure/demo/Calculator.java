package com.joe.datastructure.demo;


/**
 * 中缀表达式 的计算器 栈实现
 *
 * @author Joe
 * @create 2020/3/7 14:24
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class Calculator {

    public static void main(String[] args) {
        String expression = "40+10*30-10";
        // create two stack , one is numStack, another is operationStack
        Stack2 numStack = new Stack2(10);
        Stack2 operationStack = new Stack2(10);
        // definition parameter
        int index = 0;
        int num1;
        int num2;
        int res;
        int operator;
        // 每次扫描expressing得到的字符
        char ch;
        // 拼接多位数
        String keepNum = "";
        do {
            ch = expression.substring(index, index + 1).charAt(0);

            // 判断是否为符号
            if (operationStack.isOper(ch)) {
                // 判断符号栈是否为空
                if (!operationStack.isEmpty()) {
                    /*
                    如果符号栈有操作符, 就进行比较, 如果当前操作符的优先级小于栈中的, 就从数栈中pop2个数,
                    从符号栈pop1个符号, 进行运算, 得到结果, 将其入数栈, 然后将当前操作符入符号栈
                     */
                    if (operationStack.priority(ch) <= operationStack.priority(operationStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operationStack.pop();
                        res = numStack.cal(num1, num2, operator);
                        numStack.push(res);
                    }
                }
                // 符号栈为空, 直接入栈
                // 当前操作符大于符号栈的操作符, 直接入栈
                // is a empty, push
                operationStack.push(ch);
            } else {
                // 为数字,则直接入数栈
                // numStack.push(ch-48); // 字符1 的ASCII码为49 ,
                /*
                多位数时, 不能发现数就入栈, 还有可能有别的位
                要再看一位, 是数就进行拼接
                 */
                keepNum += ch;

                //
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operationStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 如果后一位是操作符, 则入栈,
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            // index +1 ,
            index++;
        } while (index != expression.length());

        // 表达式扫描完毕 , 顺序的弹出数字与符号, 计算
        while (!operationStack.isEmpty()) {
            // 如果符号栈为空, 计算结束, 数栈中只有一个数,
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operationStack.pop();
            res = numStack.cal(num1, num2, operator);
            numStack.push(res);
        }

        System.out.println("表达式: " + expression + " = " + numStack.pop());

    }


}

class Stack2 {
    /**
     * size of stack
     */
    private int maxSize;


    /**
     * simulate stack
     */
    private int[] stack;


    /**
     * stack top
     * no data is -1
     */
    private int top = -1;

    public Stack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }


    /**
     * justice stack is full
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * peek
     */
    public int peek() {
        return stack[top];
    }

    /**
     * justice stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }


    public void push(int value) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int result = stack[top];
        top--;
        return result;
    }

    /**
     * traversal the stack, print from the top
     */
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    // 返回运算符的优先级, 优先级使用数字表示, 数字越大, 优先级越高

    /**
     * @param operator 运算符
     */
    public int priority(int operator) {
        // char 和 int 之间的相互转换
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            // 其他符号
            return -1;
        }
    }

    /**
     * 判断是否为运算符
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     */
    public int cal(int num1, int num2, int oper) {
        // 计算的结果
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}



