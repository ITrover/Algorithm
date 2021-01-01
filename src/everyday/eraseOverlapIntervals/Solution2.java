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
class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照末尾排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int i = 0;
        int j = 1;
        int count = 1;
        while (j < intervals.length) {
            if (intervals[j][0] >= intervals[i][1]){
                // 合法的区间
                count++;
                i = j;
            }
            j++;
        }
        return intervals.length == 0 ? 0 : intervals.length - count;
    }
}
