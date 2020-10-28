package leetcode.firstUniqChar;

import java.util.HashMap;

/**
 * @author itrover
 * 387. 字符串中的第一个唯一字符 https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 使用数组记录字符出现次数
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution2 {
    public int firstUniqChar(String s) {
        int[] cnt = new int[128];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
