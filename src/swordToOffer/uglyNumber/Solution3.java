package swordToOffer.uglyNumber;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/13 15:23
 */

class Solution3 {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        // 含义：第i个位置表示第i个丑数
        int[] uglies = new int[n];
        // 初始条件
        uglies[0] = 1;
        // 乘2的位置
        int ugly2 = 0;
        // 乘3的位置
        int ugly3 = 0;
        // 乘5的位置
        int ugly5 = 0;
        int uglyIndex = 1;
        while (uglyIndex < n) {
            // 最优子结构
            // 三个可能的丑数，找到最小的
            int min = Math.min(Math.min(uglies[ugly2] * 2, uglies[ugly3] * 3), uglies[ugly5] * 5);
            uglies[uglyIndex] = min;
            // 找到乘以因子后大于当前丑数的位置
            while (uglies[ugly2] * 2 <= uglies[uglyIndex]) {
                ugly2++;
            }
            while (uglies[ugly3] * 3 <= uglies[uglyIndex]) {
                ugly3++;
            }
            while (uglies[ugly5] * 5 <= uglies[uglyIndex]) {
                ugly5++;
            }
            uglyIndex++;
        }
        return uglies[n - 1];
    }
}
