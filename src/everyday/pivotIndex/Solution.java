package everyday.pivotIndex;

/**
 * @author itrover
 * 724. 寻找数组的中心索引 https://leetcode-cn.com/problems/find-pivot-index/submissions/
 * 前缀和
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (pre[i] == suf[i]) {
                return i;
            }
        }
        return -1;
    }
}
