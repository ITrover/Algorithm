package everyday.backspaceCompare;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串(https://leetcode-cn.com/problems/backspace-string-compare/)
 * 使用栈
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        filter(S, s);
        filter(T, t);
        while (!s.isEmpty() && !t.isEmpty()) {
            if (!s.pop().equals(t.pop())) {
                return false;
            }
        }
        return s.isEmpty() && t.isEmpty();
    }

    void filter(String S, Stack<Character> s) {
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(S.charAt(i));
            }
        }
    }
}
