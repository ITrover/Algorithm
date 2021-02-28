package everyday.isMonotonic;

/**
 * @author itrover
 * 896. 单调数列 https://leetcode-cn.com/problems/monotonic-array/
 * 两次遍历,不是递增，就是递减的
 */
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        // 不是递增，就是递减的
        return increase(A) || decrease(A);
    }

    private boolean increase(int[] A){
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]){
                return false;
            }
        }
        return true;
    }

    private boolean decrease(int[] A){
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]){
                return false;
            }
        }
        return true;
    }
}
