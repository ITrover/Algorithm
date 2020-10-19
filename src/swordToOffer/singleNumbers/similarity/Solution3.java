package swordToOffer.singleNumbers.similarity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/10/19 18:15
 * @description
 * 统计计算
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution3 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 统计每个数出现的次数
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
