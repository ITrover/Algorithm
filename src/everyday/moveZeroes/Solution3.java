package everyday.moveZeroes;

/**
 * @author itrover
 * 283. 移动零 https://leetcode-cn.com/problems/move-zeroes/
 * 双指针
 * 一次遍历与0交换
 */
class Solution3 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            // 如果不是0，则和前面0交换
            if (nums[i] != 0) {
                swap(nums, i, j);
                // j指向的是0开始的地方
                j++;
            }
            i++;
        }
    }

    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
