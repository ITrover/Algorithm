package everyday.wordPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 290. 单词规律 https://leetcode-cn.com/problems/word-pattern/
 * 双向映射
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>(pattern.length());
        Map<Character, String> ch2str = new HashMap<Character, String>(pattern.length());
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            // 越界
            if (i >= m) {
                return false;
            }
            // 切割字符串
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            // 判断是否存在双向关联
            // 如果存在tmp这个key，但是value没有对上
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            // 存在ch这个key，但是value没有对上
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }
}
