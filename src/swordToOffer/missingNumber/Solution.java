package swordToOffer.missingNumber;

/**
 * 暴力解法
 *
 * 线性查找
 * 时间复杂度o(n)
 */
class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return 0;
    }

}
