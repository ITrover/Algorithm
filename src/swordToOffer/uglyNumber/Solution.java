package swordToOffer.uglyNumber;

/**
 * @author MaYunHao
 * @version 1.0
 * 剑指 Offer 49. 丑数 https://leetcode-cn.com/problems/chou-shu-lcof/
 * 动态规划
 */
class Solution {
    public int nthUglyNumber(int n) {
        // 记录因子相乘的位置
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            // 下一位可能的数字
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            // 找到最小的
            dp[i] = Math.min(Math.min(n2, n3), n5);
            // 最多移动一步，如果当前最小值是通过当前位置乘以因子获得的，则后移，下次获得的数一定比当前大
            if(dp[i] == n2) {
                a++;
            }
            if(dp[i] == n3) {
                b++;
            }
            if(dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }

}
