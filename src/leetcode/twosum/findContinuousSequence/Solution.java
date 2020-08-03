package leetcode.twosum.findContinuousSequence;


import java.util.ArrayList;
import java.util.List;

/**
 * 使用滑动窗口
 * 大了就减去最小的那个数、并增大最小的那个数（小端向右滑动）
 * 小了就加上最大的那个数、并加大最大的那个数（大端向右滑动）
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[0][0];
        }
        int small = 1;
        int big = 2;
        int middle = (1 + target) / 2;
        int sum = small + big;
        List<int[]> res = new ArrayList<>();

        while (small < big && big <= middle) {
            if (sum == target) {
                // 添加数字
                res.add(getNumbers(small, big));
            }
            while (sum > target && small < middle) {
                sum -= small;
                small++;
                if (sum == target) {
                    // 添加数字
                    res.add(getNumbers(small, big));
                }
            }
            big++;
            sum += big;
        }
        return res.toArray(new int[res.size()][]);
    }

    int[] getNumbers(int start, int end) {
        int[] res = new int[end - start + 1];
        int i = 0;
        while (start <= end) {
            res[i] = start;
            i++;
            start++;
        }
        return res;
    }
}
