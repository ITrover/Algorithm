package everyday.uniqueOccurrences;

import java.util.*;

/**
 * @author itrover
 * 1207. 独一无二的出现次数 https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * 使用hashmap 统计每个数 出现的次数
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        // 统计每个数出现的次数
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        // 判断次数是否只出现一次
        HashSet<Integer> set = new HashSet<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer,Integer> entry : entries) {
            if (set.contains(entry.getValue())){
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }
}
