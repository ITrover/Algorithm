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
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        // 二分查找到最后的一个目标值
        // 然后用线性搜索第一个
        // 一般用二分，一般用线性
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

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{};

        Solution1 solution1 = new Solution1();
        int[] range = solution1.searchRange(nums, 8);
        System.out.println(Arrays.toString(range));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
