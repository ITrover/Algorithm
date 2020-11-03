package everyday.validMountainArray;

/**
 * @author itrover
 * 941. 有效的山脉数组 https://leetcode-cn.com/problems/valid-mountain-array/
 * 满足先增加后减小即可
 * 模拟
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 2){
            return false;
        }
        int i = 0;
        int j = i;
        while (j < A.length - 1 && A[j] < A[j + 1]) {
            j++;
        }
        // 如果没有上山或上到顶端
        if (i == j || j == A.length - 1) {
            return false;
        }
        while (j < A.length - 1 && A[j] > A[j + 1]) {
            j++;
        }
        return j == A.length - 1;
    }
}
