package everyday.majorityElement;

import java.util.*;

/**
 * @author itrover
 * 229. 求众数 II https://leetcode-cn.com/problems/majority-element-ii/
 * 哈希表
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            int value = entry.getValue();
            if (value > nums.length / 3) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
