package everyday.findMinArrowShots;

import java.util.Arrays;

/**
 * @author itrover
 * 452. 用最少数量的箭引爆气球 https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 排序 + 贪心
 * 区间合并问题
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res = 0;
        int i = 0;
        while (i < points.length) {
            int start = points[i][0];
            int end = points[i][1];
            int j = i;
            // 收缩可一起射中的区间，直到无法将j位置的数组包含进去
            while (j < points.length && points[j][0] <= end && points[j][0] >= start) {
                start = Math.max(start, points[j][0]);
                end = Math.min(end, points[j][1]);
                j++;
            }
            res++;
            i = j;
        }
        return res;
    }
}
