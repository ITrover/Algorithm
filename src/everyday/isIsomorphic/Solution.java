package everyday.isIsomorphic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author itrover
 * 205. 同构字符串 https://leetcode-cn.com/problems/isomorphic-strings/
 * 同{@link everyday.wordPattern.Solution}类似
 * 双射、哈希表
 * s[i] -> t[i] , t[i] -> s[i]
 * 以下情况为false
 * 1. s[i]有映射的元素，但是不是当前的t[i]
 * 1. s[i]没有映射的元素，t[i]已经有元素映射了
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = map.get(s.charAt(i));
            if (c == null) {
                if (!set.contains(t.charAt(i))) {
                    // 建立s[i] -> t[i]的映射
                    map.put(s.charAt(i), t.charAt(i));
                    // 表示t[i]已经被映射了
                    set.add(t.charAt(i));
                } else {
                    // 不存在s[i] 到 t[i]的映射
                    // 但是t[i]已经被其他元素映射了
                    return false;
                }
            } else if (!c.equals(t.charAt(i))) {
                // 存在s[i]的映射，但不是t[i]
                return false;
            }
        }
        return true;
    }
}
