package everyday.minCut;

import java.util.*;

/**
 * @author itrover
 * 132. 分割回文串 II https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * {@link everyday.partition_palindrome.Solution}
 * 动态规划
 */
class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }
        // 初始化回文字符串判定矩阵
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }
        // 使用动态规划，求出最少的分割次数
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                // 求出0,i的字串都是回文的分割次数
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }
}
