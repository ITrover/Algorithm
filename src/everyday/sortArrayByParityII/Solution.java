package everyday.sortArrayByParityII;

/**
 * @author itrover
 * 922. 按奇偶排序数组 II https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * 双指针
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        // 同时找到奇数位置和偶数位置不符合的再替换
        while (i < A.length && j < A.length) {
            // 找到偶数位置是奇数
            while (i < A.length && A[i] % 2 == 0) {
                i += 2;
            }

            // 找到奇数位置是偶数
            while (j < A.length && A[j] % 2 != 0) {
                j += 2;
            }

            if (i < A.length && j < A.length) {
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                i += 2;
                j += 2;
            }
        }
        return A;
    }
}
