package everyday.fairCandySwap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author itrover
 * 888. 公平的糖果棒交换 https://leetcode-cn.com/problems/fair-candy-swap/
 * 哈希表
 */
class Solution2 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        // 需要改变的，带符号
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            // 交换条件
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
