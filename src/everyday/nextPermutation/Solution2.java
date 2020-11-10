package everyday.nextPermutation;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/11/10 9:19
 * 31. 下一个排列 https://leetcode-cn.com/problems/next-permutation/
 * 两次遍历
 * 时间复杂度o(n)
 */
class Solution2 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 反转
     * @param nums
     * @param start
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
