package everyday.findComplement;

/**
 * 476. 数字的补数 https://leetcode-cn.com/problems/number-complement/
 *
 * @author itrover
 * 位运算
 */
class Solution {
    public int findComplement(int num) {
        int mask = 1;
        // 计算出低位全为1且刚好大于等于num的数，作为掩码与num异或求低位反码
        for (; mask < num; mask++) {
            mask <<= 1;
        }
        return num ^ mask;
    }
}
