package swordToOffer.majorityElement;

/**
 * @author itrover
 * 169. 多数元素 https://leetcode-cn.com/problems/majority-element/
 * 摩尔投票法
 * 正负相互抵消
 * 时间复杂度 o(n)
 * 空间复杂度 o(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int times = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (times == 0){
                result = nums[i];
                times = 1;
            }else if(nums[i] == result){
                times ++;
            }else{
                times --;
            }
        }
        if (checkMoreThanHalf(nums,result)){
            return result;
        }
        return 0;
    }

    public boolean checkMoreThanHalf(int[] nums, int k) {
        int times = 0;
        int half = nums.length / 2;
        for (int num : nums) {
            if (num == k) {
                times++;
                if (times > half) {
                    return true;
                }
            }
        }
        return false;
    }
}
