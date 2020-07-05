package leetcode.searchInsert;
//，在数组给定一个排序数组和一个目标值中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = binarySearch(nums, target);
        return  i;
    }

    /**
     * 二分查找
     */
    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                //相等了直接返回
                return mid;
            } else if (nums[mid] > target) {
                // 大了缩小右边范围
                hi = mid;
            } else {
                // 小了缩小左边范围
                lo = mid + 1;
            }
        }
        //返回的一定是刚好大于等于target的位置
        return lo;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
