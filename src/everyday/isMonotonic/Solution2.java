package everyday.isMonotonic;

/**
 * @author itrover
 * 896. 单调数列 https://leetcode-cn.com/problems/monotonic-array/
 * 一次遍历，找到不符合递增或递减的情况
 */
class Solution2 {
    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        int n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] > A[i + 1]) {
                inc = false;
            }
            if (A[i] < A[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }
}
