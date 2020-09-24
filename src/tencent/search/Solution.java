package tencent.search;

/**
 * @author itrover
 * 33. 搜索旋转排序数组（https://leetcode-cn.com/problems/search-in-rotated-sorted-array/）
 * 二分查找
 * 充分利用有序的那部分数组,有序的那部分可以用二分查找
 * 判断哪边是基本有序
 * 然后判断target是否落在有序区间内
 * 时间复杂度o(log(n))
 * 空间复杂度o(1)
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断哪边是基本有序的
            if (nums[l] > nums[mid]) {
                // 右边是基本有序的
                if (target <= nums[r] && target >= nums[mid]) {
                    // 落在右边有序区间内
                    l = mid;
                } else {
                    r = mid - 1;
                }
            } else {
                // 左边是基本有序的
                if (target >= nums[l] && target <= nums[mid]) {
                    // 落在左边有序区间内
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4}, 6));
    }
}
