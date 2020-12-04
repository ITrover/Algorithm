package swordToOffer.majorityElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author itrover
 * 169. 多数元素 https://leetcode-cn.com/problems/majority-element/
 * 使用hash表记录每个数出现的个数
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : nums) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int half = nums.length / 2;
        Set<Integer> set = map.keySet();
        for (Integer num : set) {
            if (map.get(num) > half) {
                return num;
            }
        }
        return 0;
    }
}
