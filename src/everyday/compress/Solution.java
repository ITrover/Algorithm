package everyday.compress;

import java.util.Stack;

/**
 * @author itrover
 * 443. 压缩字符串 https://leetcode-cn.com/problems/string-compression/
 * 栈
 */
class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int j = 0;
        Stack<Character> stack = new Stack<>();
        while (j < chars.length) {
            int num = 1;
            // 统计当前字母位数
            while (j + num < chars.length && chars[j + num] == chars[j]) {
                num++;
            }
            chars[i] = chars[j];
            i++;
            j += num;
            // 压缩
            if (num > 1) {
                while (num > 0) {
                    stack.push((char) ((num % 10) + '0'));
                    num /= 10;
                }
                while (!stack.isEmpty()) {
                    chars[i++] = stack.pop();
                }
            }
        }
        return i;
    }
}
