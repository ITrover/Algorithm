package leetcode.twosum;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/8/2 19:23
 */

/**
 * 双指针
 * 时间复杂度 o(n)
 * 空间复杂度 o(1)
 */
class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            if (nums[low] + nums[high] < target){
                low ++;
            }else if (nums[low] + nums[high] > target){
                high --;
            }else{
                break;
            }
        }
        return new int[]{nums[low],nums[high]};
    }
}
