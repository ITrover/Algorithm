package swordToOffer.findRepeatNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/3 19:25
 */

/**
 *
 * 使用Set的特性
 * Set中没有重复的数据、
 * 如果添加失败，那么当前添加的一定重复了
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums
             ) {
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }
}
