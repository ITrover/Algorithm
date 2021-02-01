package everyday.fairCandySwap;

import java.util.Arrays;

/**
 * @author itrover
 * 888. 公平的糖果棒交换 https://leetcode-cn.com/problems/fair-candy-swap/
 * 哈希表
 */
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int a = Arrays.stream(A).sum();
        int b = Arrays.stream(B).sum();
        boolean[] map = new boolean[100001];
        for (int item : A) {
            map[item] = true;
        }
        int delta = (a - b) / 2;
        int[] res = new int[2];
        for (int y : B) {
            // 交换条件
            int x = y + delta;
            if (x > 0 && x < 100001 && map[x]) {
                res[0] = x;
                res[1] = y;
                break;
            }
        }
        return res;
    }
}
