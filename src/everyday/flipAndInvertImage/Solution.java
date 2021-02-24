package everyday.flipAndInvertImage;

/**
 * @author itrover
 * 832. 翻转图像 https://leetcode-cn.com/problems/flipping-an-image/
 * 双指针
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] a : A) {
            int len = a.length;
            int i = 0;
            int j = len - 1;
            // 110
            // 011
            // 100
            // 如果是对称的两个元素相等，则都变，否则都不变
            // 如果是奇数个的中间的那个数，那么取反
            while (i <= j) {
                if (a[i] == a[j]) {
                    if (i == j) {
                        a[i] = a[i] == 1 ? 0 : 1;
                    }
                    a[i] = a[i] == 1 ? 0 : 1;
                    a[j] = a[j] == 1 ? 0 : 1;
                }
                i++;
                j--;
            }
        }
        return A;
    }
}
