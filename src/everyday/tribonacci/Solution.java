package everyday.tribonacci;

/**
 * @author itrover
 * 1137. 第 N 个泰波那契数 https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * 动态规划
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int r = 0;
        while (n-- > 2) {
            r = t2 + t1 + t0;
            t0 = t1;
            t1 = t2;
            t2 = r;
        }
        return r;
    }
}
