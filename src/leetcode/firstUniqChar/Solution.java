package leetcode.firstUniqChar;

import java.util.HashMap;

/**
 * @author itrover
 * 387. 字符串中的第一个唯一字符 https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * Hash表 两次遍历
 * 时间复杂度o(n)
 * 空间复杂度o(1) // 字符的数量就有限
 */
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
