package leetcode.trailingZeroes;

/**
 * @author itrover
 * 172. 阶乘后的零 https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * 时间复杂度o(log(n))
 * 寻找5出现的规律o(log(n))
 */
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
