package everyday.maxScore;

/**
 * @author itrover
 * 1423. 可获得的最大点数 https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * 滑动窗口
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution2 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[k - i + 1];
            sum += cardPoints[cardPoints.length - i - 1];
            max = Math.max(sum, max);
        }
        return max;
    }
}
