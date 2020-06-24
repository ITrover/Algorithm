package leetcode.searchRange;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)
