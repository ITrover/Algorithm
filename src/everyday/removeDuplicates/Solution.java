package everyday.removeDuplicates;

import java.util.Stack;

/**
 * @author itrover
 * 1047. 删除字符串中的所有相邻重复项 https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 栈
 */
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(S.charAt(i))) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        char[] str = new char[stack.size()];
        for (int i = str.length - 1; i >= 0; i--) {
            str[i] = stack.pop();
        }
        return new String(str);
    }
}
