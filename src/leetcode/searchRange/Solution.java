package leetcode.searchRange;

/**
 * @author itrover
 * 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 二分查找
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 二分查找
        int[] result = new int[]{-1,-1};
        boolean left = true;
        int leftIdx = extremeIndex(nums,target,true);
        if (leftIdx == nums.length || nums[leftIdx] != target){
            return result;
        }
        result[0] = leftIdx;
        result[1] = extremeIndex(nums,target,false) - 1;
        return result;
    }

    private int extremeIndex(int[] nums, int target, boolean left) {
        //左边
        int lo = 0;
        //右边
        int hi = nums.length;
        while (lo < hi) {
            // 二分查找
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || left && nums[mid] == target) {
                // 中间的数，比目标值大
                // 缩小右边范围
                hi = mid;
            } else {
                // 缩小左边范围
                lo = mid + 1;
            }
        }
        return lo;
    }
}
