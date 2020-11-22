package everyday.sortArrayByParityII;

/**
 * @author itrover
 * 922. 按奇偶排序数组 II https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * 双指针 更加简洁的写法
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution2 {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            // 找到偶数位置不符合后再去找奇数位置的来替换
            if (A[i] % 2 == 1) {
                while (j < A.length && A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, j, i);
            }
        }
        return A;
    }
    private void swap(int[] a, int j, int i) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
