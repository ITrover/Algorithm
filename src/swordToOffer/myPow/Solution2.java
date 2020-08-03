package swordToOffer.myPow;

/**
 * 循环法
 * 时间复杂度 o(n)
 */
class Solution2 {

    public double myPow(double x, int n) {
        // 如果小于0
        // 将 n 变为正数
        // 将 x 变为分数
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1;
        for (int i = 0; i < n; i++) {
            res*=x;
        }
        return res;
    }
}
