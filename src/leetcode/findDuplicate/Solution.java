package leetcode.findDuplicate;

/**
 * @author itrover
 * 287. 寻找重复数 https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 二分查找
 */
class Solution {
    public int findDuplicate(int[] nums) {
        // 二分查找
        // 时间复杂度o(nlog(n))
        // 在[1,n]中查找重复的数
        int l = 1, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int cnt = 0;
            // 统计小于mid的数量
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            // 如果mid之前有数重复，那么cnt > mid
            if (cnt > mid) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
