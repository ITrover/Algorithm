package everyday.calculate.improve;

import java.util.Stack;

/**
 * @author itrover
 * 面试题 16.26. 计算器 https://leetcode-cn.com/problems/calculator-lcci/
 * 栈
 */
class Solution02 {
    public int calculate(String s) {
        Stack<Character> operation = new Stack<>();
        Stack<Integer> number = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            // 获取数字
            if (Character.isDigit(c)) {
                int num = c - '0';
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num *= 10;
                    num += s.charAt(i) - '0';
                    i++;
                }
                i--;
                number.push(num);
            } else {
                // 获取操作符号
                if (!operation.isEmpty() && priority(operation.peek(), c)) {
                    // 当前优先级小，那么弹出栈顶的操作
                    while (!operation.isEmpty() && priority(operation.peek(), c)) {
                        Character op = operation.pop();
                        Integer a2 = number.pop();
                        Integer a1 = number.pop();
                        number.push(calculate(op, a1, a2));
                    }
                }
                operation.push(c);
            }
        }
        while (!operation.isEmpty()) {
            Character c = operation.pop();
            Integer a2 = number.pop();
            Integer a1 = number.pop();
            number.push(calculate(c, a1, a2));
        }
        return number.isEmpty() ? -1 : number.pop();
    }

    private int calculate(char c, int a1, int a2) {
        switch (c) {
            case '+':
                return a1 + a2;
            case '-':
                return a1 - a2;
            case '*':
                return a1 * a2;
            case '/':
                return a1 / a2;
        }
        return 0;
    }

    /**
     * 比较a、b的优先级
     * @param a a为栈内操作符
     * @param b b为栈外操作符
     * @return true if a优先于b
     * 栈内操作符大于其对应的栈外操作符
     * 乘除 > 加减
     */
    boolean priority(char a, char b) {
        if (b == '+' || b == '-') {
            // 如果栈外是+-，那么不管a是+-*/都优先于b
            return true;
        } else {
            // 如果栈外是*/，那么只有a是*/才优先于b
            return a == '*' || a == '/';
        }
    }
}
