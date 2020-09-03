package swordToOffer.minNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author itrover
 * 剑指Offer45.把数组排成最小的数
 * 本质上就是一个排序问题
 * 定义一个排序规则
 *
 */
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 排序规则
        // 两个字符串s1，s2相加
        // 比较哪个应该在前面
        // s1 + s2 > s2 + s1，那么s1应该在前面
        // s1 + s2 < s2 + s1，那么s2应该在前面
        Arrays.sort(strs, (s1,s2)-> (s1 + s2).compareTo(s2 + s1));
        StringBuilder res = new StringBuilder();
        for (String s:strs) {
            res.append(s);
        }
        return res.toString();
    }
}