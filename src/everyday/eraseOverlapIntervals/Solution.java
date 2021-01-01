package everyday.eraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author itrover
 * 435. 无重叠区间 https://leetcode-cn.com/problems/non-overlapping-intervals/
 * 双指针
 * 按照末尾排序
 * 时间复杂度o(n*log(n))
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照末尾排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int i = 0;
        int j = 1;
        int res = 0;
        while (j < intervals.length) {
            if (intervals[i][1] > intervals[j][0]) {
                // 有重叠部分
                // 跳过j
                j++;
                res++;
            } else {
                i = j;
                j++;
            }
        }
        return res;
    }
}
