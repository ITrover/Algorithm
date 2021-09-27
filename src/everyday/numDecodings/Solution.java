package everyday.numDecodings;

import java.util.Arrays;

/**
 * @author itrover
 * 639. 解码方法 II https://leetcode-cn.com/problems/decode-ways-ii/
 * 回溯 dfs 记忆
 */
class Solution {

    int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        // 记忆，memo[i]表示[i,n)可能有多少编码方式
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        return (int) dfs(s, 0, memo);
    }

    private long dfs(String s, int i, long[] memo) {
        if (i >= s.length()) {
            return 1;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        // 本次使用一个和两个字符的情况的和
        long a = check1digit(s.charAt(i)) * dfs(s, i + 1, memo) % MOD;
        long b = (i + 1 >= s.length() ? 0 : check2digits(s.charAt(i), s.charAt(i + 1)) * dfs(s, i + 2, memo)) % MOD;
        long ans = (a + b) % MOD;
        memo[i] = ans;
        return ans;
    }

    public int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }
}
