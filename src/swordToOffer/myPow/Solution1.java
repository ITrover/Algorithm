package swordToOffer.myPow;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 强烈建议使用
 * 快速幂解析（二进制角度）
 *          可以通过
 *          o(1)
 * @date 2020/7/9 13:22
 */

class Solution1 {
    public double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        // 二进制的角度
        while(b > 0) {
            // n % 2 == 1 时则与x相乘
            if((b & 1) == 1) {
                res *= x;
            }
        // x双倍自身增加，对于n的每个二进制位，应该乘以的值
            x *= x;
            // b 整除2
            b >>= 1;
        }
        return res;
    }

}

