package leetcode.LongestSubstring;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/3 15:35
 * @description 剑指 Offer 48. 最长不含重复字符的子字符串
 * 双指针+hashset
 * 时间复杂度o(n^2)
 * 空间复杂度o(1) 最多就26个字符
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            } else {
                if (set.size() > max) {
                    max = set.size();
                }
                set.clear();
                i++;
                j = i;
            }
        }
        if (set.size() > max) {
            max = set.size();
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }
}
