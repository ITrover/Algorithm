package everyday.maxScore;

/**
 * @author itrover
 * 1423. 可获得的最大点数 https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * 前缀和
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = cardPoints[i] + dp[i - 1];
        }
        int[] dp2 = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp2[k - i] = cardPoints[cardPoints.length - i] + dp2[k - i + 1];
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            max = Math.max(dp[i] + dp2[i], max);
        }
        return max;
    }
}
