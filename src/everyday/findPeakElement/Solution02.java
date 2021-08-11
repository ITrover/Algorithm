package everyday.findPeakElement;

/**
 * @author itrover
 * 162. 寻找峰值 https://leetcode-cn.com/problems/find-peak-element/
 * 二分查找
 * 时间复杂度o(logn)
 */
class Solution02 {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        return findPeakElement(nums, 0, n - 1);
    }

    public int findPeakElement(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        // 左右两边是否有峰值
        int r = findPeakElement(nums, start, mid - 1);
        int l = findPeakElement(nums, mid + 1, end);
        if (r != l) {
            return r == -1 ? l : r;
        }
        // 当前元素是否为峰值
        if (mid == 0) {
            return nums[1] < nums[0] ? mid : -1;
        }
        if (mid == nums.length - 1) {
            return nums[mid - 1] < nums[mid] ? mid : -1;
        }
        if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        return -1;
    }
}
