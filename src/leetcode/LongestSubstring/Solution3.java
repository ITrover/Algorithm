package leetcode.LongestSubstring;

import java.util.HashMap;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/3 16:37
 * @description
 * 双指针+HashMap
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int i = 0;
        int j = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while (j < s.length()) {
            if (map.get(s.charAt(j)) == null) {
                map.put(s.charAt(j),j);
                j++;
            } else {
                if (map.size() > max) {
                    max = map.size();
                }
                // 移动到出现重复字符的后面
                i = map.get(s.charAt(j)) + 1;
                map.clear();
                j = i;
            }
        }
        if (map.size() > max) {
            max = map.size();
        }
        return max;
    }
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}
