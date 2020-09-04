package swordToOffer.cuttingRope;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/4 9:21
 * @description 剑指 Offer 14- I. 剪绳子
 * 贪婪算法
 * n <= 3 n-1
 * n = 4 2*2
 * n = 5 3*2
 * n = 6 3*3
 * n = 7 3*2*2
 * 规则就是只要n能被3减去，就一直减
 * 如果最后n为0，那么直接返回。
 *          1，那么退回一个3，然后拆分成2+2。结果除3，乘4。
 *          2，那么结果乘2后返回。
 */
public class Solution2 {
    public int cuttingRope(int n) {
        if (n <= 3){
            return n - 1;
        }
        int res = 1;
        while (n >= 3) {
            res *= 3;
            n -= 3;
        }
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            return res / 3 * 4;
        }
        return res * 2;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.cuttingRope(8));
    }
}
