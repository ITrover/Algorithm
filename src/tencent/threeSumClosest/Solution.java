package tencent.threeSumClosest;

import java.util.Arrays;

/**
 * @author itrover
 * 16. 最接近的三数之和（https://leetcode-cn.com/problems/3sum-closest/）
 * 联系三数之和
 *
 * 排序+双指针
 * 时间复杂度o(n^2)
 * 空间复杂度o(1)
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            // 先固定一个
            int l = i + 1; int r = nums.length - 1;
            // 找到两个数，使三个数加起来接近target
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                // 可优化，有一个最优的位置
                if (sum < target){
                    l ++;
                }else if(sum > target){
                    r--;
                }else {
                    return res;
                }
            }
        }
        return res;
    }
}