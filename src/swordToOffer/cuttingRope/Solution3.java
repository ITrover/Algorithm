package swordToOffer.cuttingRope;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/4 9:21
 * @description 剑指 Offer 14- I. 剪绳子
 * 考虑大数越界的问题
 * 方法：循环求余，快速幂
 */
public class Solution3 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        int p = 1000000007;
        //  (res * x) 可能会超过 int 的取值范围
        long res = 1;
        long x = 3;
        for (int a = (n / 3) - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                res = (res * x) % p;
            }
            x = (x * x) % p;
        }
        if (b == 0) {
            return (int) (res * 3 % p);
        }
        if (b == 1) {
            return (int) (res * 4 % p);
        }
        return (int) (res * 6 % p);
    }
}
