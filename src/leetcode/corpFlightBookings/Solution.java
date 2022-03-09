package leetcode.corpFlightBookings;

/**
 * 1109. 航班预订统计 https://leetcode-cn.com/problems/corporate-flight-bookings/
 * 差分
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] dp = new int[n + 1];
        for (int[] booking:bookings) {
            int l = booking[0] - 1, r = booking[1], seats = booking[2];
            dp[l] += seats;
            // 保证只对l,r-1产生影响
            dp[r] -= seats;
        }
        int[] res = new int[n];
        res[0] = dp[0];
        // 前缀和
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + dp[i];
        }
        return res;
    }
}
