package everyday.validMountainArray;

/**
 * @author itrover
 * 941. 有效的山脉数组 https://leetcode-cn.com/problems/valid-mountain-array/
 * 双指针
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution2 {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 2){
            return false;
        }
        int i = 0;
        int j = A.length - 1;
        while (i < A.length - 1 && A[i] < A[i + 1]){i++;}
        while (j > 0 && A[j] < A[j - 1]){j--;}
        return i == j && i != 0 && j != A.length - 1;
    }
}
