package swordToOffer.uglyNumber;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/13 15:11
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
            // 此时选出的就是最小的，下次选出的，一定比这个大
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
