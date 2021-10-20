package everyday.minMoves;

import java.util.Arrays;

/**
 * @author itrover
 * 453. 最小操作次数使数组元素相等 https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 * 技巧性
 * 让n-1个元素加1，相当于让另外一个元素-1
 */
class Solution {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
