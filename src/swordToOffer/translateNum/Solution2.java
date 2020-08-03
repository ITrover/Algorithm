package swordToOffer.translateNum;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/26 20:05
 */

/**
 * 动态规划，求余的方式
 */
class Solution2 {
    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
