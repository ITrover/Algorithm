package swordToOffer.missingNumber;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/28 21:33
 */

/**
 * 二分查找
 */
class Solution2 {
    public int missingNumber(int[] nums) {
            int i = 0, j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if(nums[m] == m) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
            return nums.length + 1;
    }
}
