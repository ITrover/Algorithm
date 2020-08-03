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
        int[] uglies = new int[n];
        uglies[0] = 1;
        int ugly1 = 0;
        int ugly3 = 0;
        int ugly5 = 0;
        int uglyIndex = 1;
        while (uglyIndex < n) {
            // 三个可能的丑数，找到最小的
            int min = Math.max(Math.min(uglies[ugly1] * 2, uglies[uglies[ugly3] * 3]), uglies[ugly5] * 5);
            uglies[uglyIndex] = min;
            // 找到小于当前丑数的位置
            while (uglies[ugly1] * 2 <= uglies[uglyIndex]) {
                ugly1++;
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
