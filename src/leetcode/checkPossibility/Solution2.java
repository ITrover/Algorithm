package leetcode.checkPossibility;

/**
 * @author itrover
 * 665. 非递减数列 https://leetcode-cn.com/problems/non-decreasing-array/
 * 贪心算法
 */
class Solution2 {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            // 合格的情况
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            cnt++;
            // 非法情况
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                // i - 2 和 i也是递减的，说明第i个太小了
                nums[i] = nums[i - 1];
            } else {
                // 如果i是第2个元素（即i==1），或者i - 2 和 i是递增的，说明第i个太大了
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
