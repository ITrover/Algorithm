package everyday.flipAndInvertImage;
/**
 * @author itrover
 * 832. 翻转图像 https://leetcode-cn.com/problems/flipping-an-image/
 * 双指针，优化
 */
class Solution2 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] a : A) {
            int len = a.length;
            int i = 0;
            int j = len - 1;
            while (i < j) {
                if (a[i] == a[j]) {
                    a[i] ^= 1;
                    a[j] ^= 1;
                }
                i++;
                j--;
            }
            if (i == j) {
                a[i] ^= 1;
            }
        }
        return A;
    }
}
