package everyday.removeKdigits;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author itrover
 * 402. 移掉K位数字 https://leetcode-cn.com/problems/remove-k-digits/
 * 贪心 + 单调栈
 * 使用数组实现
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution4 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        int length = num.length();
        char[] res = new char[length];
        int resLen = num.length() - k;
        int j = -1;
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            // 回退，保证res为单调栈，从小到大
            while (k > 0 && j >= 0 && res[j] > digit) {
                k--;
                j--;
            }
            j++;
            res[j] = digit;
        }
        j = 0;
        // 去掉前面的0
        while (j < length && res[j] == '0') {
            j++;
        }
        return j == resLen ? "0" : new String(res, j, resLen - j);
    }
}
