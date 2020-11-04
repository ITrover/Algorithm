package everyday.insert;

import java.util.ArrayList;

/**
 * @author itrover
 * 57. 插入区间 https://leetcode-cn.com/problems/insert-interval/
 * 模拟法
 * 时间复杂度o(n)
 * 分段求解
 * 左边无交集部分
 * 中间有交集或插入部分
 * 右边无交集部分
 */
class Solution2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        int i = 0;
        ArrayList<int[]> rs = new ArrayList<>();
        // 左边无交集部分
        while (i < intervals.length && intervals[i][1] < left) {
            rs.add(intervals[i]);
            i++;
        }
        // 中间有交集部分
        while (i < intervals.length && intervals[i][0] < right) {
            left = Math.min(intervals[i][0], left);
            right = Math.max(intervals[i][1], right);
            i++;
        }
        // 插入有交集部分
        rs.add(new int[]{left, right});
        // 右边无交集部分
        while (i < intervals.length) {
            rs.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[rs.size()][2];
        rs.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
    }
}
