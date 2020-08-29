package swordToOffer.firstUniqChar;

import java.util.HashMap;

/**
 * 使用hash表
 * 时间复杂度 o(n)
 * 空间复杂度 o(1)，最多也就那么多个字符
 */
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)).equals(1)){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}