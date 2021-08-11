package everyday.findPeakElement;

/**
 * @author itrover
 * 162. 寻找峰值 https://leetcode-cn.com/problems/find-peak-element/
 * 二分查找 迭代的方式
 * 时间复杂度o(logn)
 */
class Solution04 {

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        while (l != r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
