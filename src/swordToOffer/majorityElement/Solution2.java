package swordToOffer.majorityElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/22 19:57
 */

/**
 * 使用hash表记录每个数出现的个数
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
        return  0;
    }
}
