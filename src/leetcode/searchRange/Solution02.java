package leetcode.searchRange;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2021/9/5 12:35
 */
public class Solution02 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }

    int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (target <= nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            }
        }
        if (l == nums.length || nums[l] != target) {
            return -1;
        }
        return l;
    }

    int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target >= nums[mid]) {
                l = mid + 1;
            }
        }
        if (r == -1 || nums[r] != target) {
            return -1;
        }
        return r;
    }
}
