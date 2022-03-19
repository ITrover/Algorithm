package everyday.reverseParentheses;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author itrover
 * 1190. 反转每对括号间的子串 https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * 技巧性
 */
class Solution02 {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                // 成为一个括号对，记录括号对应的位置
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                // 让index从与之匹配的地方开始遍历
                index = pair[index];
                // 方向相反
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}
