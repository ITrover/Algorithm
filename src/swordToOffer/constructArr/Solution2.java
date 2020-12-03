package swordToOffer.constructArr;

import java.util.Arrays;

/**
 * @author itrover
 * 剑指 Offer 66. 构建乘积数组 https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * 动态规划，累乘，矩阵，下三角，上三角
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution2 {
    public int[] constructArr(int[] a) {
        if(a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
