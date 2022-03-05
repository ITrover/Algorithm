package leetcode.minRemoveToMakeValid;

/**
 * 1249. 移除无效的括号 https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/
 * 栈
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] t = new char[n];
        int k = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                k++;
                t[j++] = s.charAt(i);
            } else if (s.charAt(i) == ')') {
                if (k > 0) {
                    k--;
                    t[j++] = s.charAt(i);
                }
            } else {
                t[j++] = s.charAt(i);
            }
        }
        // 符合要求的情况
        if (k == 0) return new String(t, 0, j);
        int i = j - k;
        k = 0;
        j--;i--;
        char[] res = new char[i + 1];
        for (; j >= 0; j--) {
            if (t[j] == ')') {
                k++;
                res[i--] = t[j];
            } else if (t[j] == '(') {
                if (k > 0) {
                    k--;
                    res[i--] = t[j];
                }
            } else {
                res[i--] = t[j];
            }
        }
        return new String(res);
    }
}
