package leetcode.firstMissingPositive;


/**
 * @author itrover
 * 41. 缺失的第一个正数 https://leetcode-cn.com/problems/first-missing-positive/
 * 原地哈希
 * 将1,n依次放在数组的[0,n-1]的位置，若num[i] != i + 1，则该数缺失
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

}
