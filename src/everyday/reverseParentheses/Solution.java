package everyday.reverseParentheses;


import java.util.Stack;

/**
 * @author itrover
 * 1190. 反转每对括号间的子串 https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * 栈
 */
class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 将前一部分放入栈中
                stack.push(sb);
                // 开始()里的一段
                sb = new StringBuilder();
            } else if (c == ')') {
                // 前面部分 + ()里的部分
                sb = stack.pop().append(sb.reverse());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseParentheses("(ed(et(oc))el)"));
    }
}
