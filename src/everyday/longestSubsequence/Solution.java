package everyday.longestSubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 1218. 最长定差子序列 https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 * 动态规划
 */
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        // 状态定义：dp[v]表示以v结尾的最长等差子序列的长度
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            // 状态转移方程：dp[v] = dp [v - difference] + 1
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }
}
