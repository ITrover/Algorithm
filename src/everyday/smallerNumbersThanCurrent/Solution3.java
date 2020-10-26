package everyday.smallerNumbersThanCurrent;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author itrover
 * 1365. 有多少小于当前数字的数字 https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * 快速排序
 * 时间复杂度o(nlog(n))
 */
class Solution3 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        // 记录数字的下标，排序后会改变
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] data1, int[] data2) {
                return data1[0] - data2[0];
            }
        });
        int[] ret = new int[n];
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (data[i][0] != data[i - 1][0]){
                prev = i;
            }
            // 找到该数字之前所在的位置并对结果赋值
            ret[data[i][1]] = prev;
        }
        return ret;
    }
}
