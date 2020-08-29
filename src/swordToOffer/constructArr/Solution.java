package swordToOffer.constructArr;

/**
 * 蛮力法
 * 时间复杂度o(n*n)
 * 空间复杂度o(1)
 *
 * 超出时间限制
 */
class Solution {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            // 跳过第i个，计算res[i]的值
            int c = 1;
            for (int j = 0; j < i; j++) {
                c *= a[j];
            }
            for (int j = i + 1; j < a.length; j++) {
                c *= a[j];
            }
            res[i] = c;
        }
        return res;
    }
}