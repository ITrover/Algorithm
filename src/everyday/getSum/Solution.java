package everyday.getSum;

/**
 * @author itrover
 * 371. 两整数之和 https://leetcode-cn.com/problems/sum-of-two-integers/
 * 位运算
 */
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // 进位
            int carry = (a & b) << 1;
            // 不进位加法
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
