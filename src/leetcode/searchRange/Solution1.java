package leetcode.searchRange;

/**
 * @author itrover
 * 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 二分查找
 */
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        // 二分查找到最后的一个目标值
        // 然后用线性搜索第一个
        // 一半用二分，一半用线性
        int[] result = new int[]{-1, -1};
        int index = extremeIndex(nums, target) - 1;
        if (index >= nums.length || index < 0 || nums[index] != target) {
            return result;
        }
        result[1] = index;
        int i = index;
        while (i >= 0 && nums[i] == target) {
            i--;
        }
        result[0] = i + 1;
        return result;
    }

    private int extremeIndex(int[] nums, int target) {
        //左边
        int lo = 0;
        //右边
        int hi = nums.length;
        //寻找到的是刚好超过target的数
        while (lo < hi) {
            // 二分查找
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) {
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
