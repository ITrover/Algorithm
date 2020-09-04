package swordToOffer.cuttingRope;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/4 9:21
 * @description 剑指 Offer 14- I. 剪绳子
 * 数学推导
 *
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) (Math.pow(3, a) * 2);
    }
}
