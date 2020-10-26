package everyday.longestMountain;

/**
 * @author itrover
 * 845. 数组中的最长山脉 https://leetcode-cn.com/problems/longest-mountain-in-array/
 * 枚举山顶
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution {
    public int longestMountain(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        // 以i处为山顶，左边的个数
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }

        int[] right = new int[n];
        // 以i处为山顶，右边的个数
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        // 计算山顶两边两边的个数
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
