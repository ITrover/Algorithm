package tencent.uniquePaths;

/**
 * @author itrover
 * 62. 不同路径(https://leetcode-cn.com/problems/unique-paths/)
 * 递归
 * 超时
 */
class Solution {
    int count = 0;

    public int uniquePaths(int m, int n) {
        dfs(m, n);
        return count;
    }

    void dfs(int m, int n) {
        if (m < 1 || n < 1) {
            return;
        }
        if (m == 1 || n == 1) {
            count += 1;
        }
        // 向右走
        uniquePaths(m - 1, n);
        // 向下走
        uniquePaths(m, n - 1);
    }
}