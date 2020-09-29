package tencent.uniquePaths;

import java.util.Arrays;

/**
 * @author itrover
 * 动态规划
 * 空间优化
 * 时间复杂度O(m*n)
 * 空间复杂度O(n)
 */
class Solution3 {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 本行当前位置前一个数 + 当前位置上一行对应的数
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}