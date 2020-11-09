package leetcode.trailingZeroes;

/**
 * @author itrover
 * 172. 阶乘后的零 https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * 时间复杂度o(n)
 * 遍历找因子
 */
class Solution2 {
    public int trailingZeroes(int num) {
        int rs = 0;
        for (int i = 1; i <= num; i++) {
            int j = i;
            while (j % 5 == 0) {
                rs++;
                j /= 5;
            }
        }
        return rs;
    }
}
