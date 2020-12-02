package swordToOffer.myPow;

/**
 * 二分法
 * x^n = x^(n/2)*xx^(n/2) = .....
 */
class Solution4 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        long b = n;
        double res = 1;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 1) {
            if (b % 2 == 1) {
                res *= x;
            }
            x *= x;
            b /= 2;
        }
        res *= x;
        return res;
    }
}
