package leetcode.canReorderDoubled;

import java.util.*;

/**
 * @author itrover
 * 954. 二倍数对数组 https://leetcode-cn.com/problems/array-of-doubled-pairs/
 * 排序 + 贪心
 */
class Solution02 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        // 0 只能对应 0
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> vals = new ArrayList<>(cnt.keySet());
        // 由小到大排序
        vals.sort(Comparator.comparingInt(Math::abs));
        for (int x : vals) {
            // 无法找到足够的 2x 与 x 配对
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) {
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }
}
