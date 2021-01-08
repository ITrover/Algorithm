package everyday.rotate;

/**
 * @author itrover
 * 189. 旋转数组 https://leetcode-cn.com/problems/rotate-array/
 * 向前冒泡
 * 时间复杂度o(k*(length - k))
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length < 1){
            return;
        }
        int len = nums.length;
        k %= len;
        int m = len - k;
        for (int i = m; i < len; i++) {
            int t = i;
            for (int j = 0; j < m; j++) {
                swap(nums, t, t - 1);
                t--;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
