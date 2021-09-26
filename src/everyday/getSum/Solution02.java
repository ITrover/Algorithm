package everyday.getSum;

/**
 * @author itrover
 * 371. 两整数之和 https://leetcode-cn.com/problems/sum-of-two-integers/
 * 位运算
 */
class Solution02 {
    public int getSum(int a, int b) {
        int res = 0;
        int c = 0;
        for (int i = 0; i < 32; i++) {
            int x = (a >> i) & 1;
            int y = (b >> i) & 1;
            if ((x & y) == 1) {
                // 末尾都为1，这一位为上一次的进位，同时本次进位
                res |= c << i;
                c = 1;
            } else if ((x | y) == 1) {
                // 不同，结果为1与上一次进位异或，进位与上一次相同
                res |= (c ^ 1) << i;
            } else {
                // 都为0，这一位为上一次的进位，同时本次不进位
                res |= c << i;
                c = 0;
            }
        }
        return res;
    }
}
