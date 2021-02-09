package everyday.subarraysWithKDistinct;


/**
 * @author itrover
 * 992. K 个不同整数的子数组 https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
 * 滑动窗口
 */
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] lower = new int[n], upper = new int[n];
        // 左边最近满足k个字符的位置
        find(lower, nums, k);
        // 左边最近满足k - 1个字符的位置
        find(upper, nums, k - 1);
        int ans = 0;
        // upper - lower即为满足i位置满足k个字符的个数
        for (int i = 0; i < n; i++) {
            ans += upper[i] - lower[i];
        }
        return ans;
    }

    void find(int[] pos, int[] nums, int k) {
        int n = nums.length;
        // 题目条件 1 <= A[i] <= A.length
        int[] cnt = new int[n + 1];
        int ans = 0;
        // i 为右指针，j为左指针，构成窗口
        for (int i = 0, j = 0, sum = 0; i < n; i++) {
            int right = nums[i];
            if (cnt[right] == 0) {
                sum++;
            }
            cnt[right]++;
            // 从左边开始找，找到最近满足k个字符的位置
            while (sum > k) {
                int left = nums[j++];
                cnt[left]--;
                if (cnt[left] == 0) {
                    sum--;
                }
            }
            // 记录位置
            pos[i] = j;
        }
    }
}
