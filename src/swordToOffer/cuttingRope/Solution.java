package swordToOffer.cuttingRope;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/4 9:21
 * @description 剑指 Offer 14- I. 剪绳子 https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 数学推导
 * 尽量把绳子分成多个长度为 3 的片段
 * 分情况对不能分成3的片段处理
 * 0 不用处理
 * 1 将一个3的片段分解，因为2x2 > 3x1
 * 2 与3的片段相乘后返回
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
