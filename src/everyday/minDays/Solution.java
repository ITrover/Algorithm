package everyday.minDays;

/**
 * @author itrover
 * 1482. 制作 m 束花所需的最少天数 https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * 二分查找
 */
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // 如果没有足够多的连续k天
        if (m > bloomDay.length / k) {
            return -1;
        }
        // 只要有足够的天数，就不会做不出m朵花
        int low = Integer.MAX_VALUE, high = 0;
        int length = bloomDay.length;
        // 寻找最大值和最小值
        for (int i = 0; i < length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        // 二分查找，寻找最小需要的天数
        while (low < high) {
            int days = (high - low) / 2 + low;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            // 如果小于day，那么一定开花了
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                // 不连续了
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
