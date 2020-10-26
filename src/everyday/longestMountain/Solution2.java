package everyday.longestMountain;

/**
 * @author itrover
 * 845. 数组中的最长山脉 https://leetcode-cn.com/problems/longest-mountain-in-array/
 * 模拟
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution2 {
    public int longestMountain(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            // 判断是否符合山脚
            if (A[left] < A[left + 1]) {
                // 从山脚一直到山顶
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right;
                }
                // 避免出现相等的情况
                if (right < n - 1 && A[right] > A[right + 1]) {
                    // 从山顶到山脚
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right;
                    }
                    // 经历从山脚到山顶，再从山顶到山脚的才能被判定为山
                    ans = Math.max(ans, right - left + 1);
                } else {
                    // 平了，不符合条件
                    ++right;
                }
            }
            left = right;
        }
        return ans;
    }
}
