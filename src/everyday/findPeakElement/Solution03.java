package everyday.findPeakElement;

/**
 * @author itrover
 * 162. 寻找峰值 https://leetcode-cn.com/problems/find-peak-element/
 * 二分查找
 * 题目中条件不可能存在两个相邻元素相等的情况
 * 时间复杂度o(logn)
 */
class Solution03 {

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        // 处于下降的序列，则往左边搜索
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        }
        // 处于上升的序列，则往右边搜索
        return search(nums, mid + 1, r);
    }

}
