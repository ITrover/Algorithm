package leetcode.decodeString;

import java.util.Stack;

/**
 * @author itrover
 * 394. 字符串解码 https://leetcode-cn.com/problems/decode-string/
 * 栈
 */
class Solution {
    public String decodeString(String s) {
        int multi = 0;
        Stack<Integer> stackNum = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                // 放入重复的次数
                stackNum.push(multi);
                multi = 0;
                // 放入数字前的字符串
                stackStr.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                // 出栈
                int n = stackNum.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stackStr.pop() + tmp);
            } else if (c >='0' && c <= '9') {
                multi = multi*10 + c - '0';
            } else {
                // 字母
                res.append(c);
            }
        }
        return res.toString();
    }
}
