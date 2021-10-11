package leetcode.evalRPN;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author itrover
 * 剑指 Offer II 036. 后缀表达式 https://leetcode-cn.com/problems/8Zf90G/
 * 栈，简单题，不用考虑运算符优先级
 */
class Solution {

    private static String ADD = "+";
    private static String DELETE = "-";
    private static String MULTIPLE = "*";
    private static String DIVIDE = "/";

    private Set<String> set = new HashSet<>();
    {
        set.add(ADD);
        set.add(DELETE);
        set.add(MULTIPLE);
        set.add(DIVIDE);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!set.contains(token)) {
                stack.add(Integer.valueOf(token));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(calc(b, a, token));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }

    private int calc(int a, int b, String token) {
        if (token.equals(ADD)) {
            return a + b;
        } else if (token.equals(DELETE)) {
            return a - b;
        } else if (token.equals(MULTIPLE)) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
