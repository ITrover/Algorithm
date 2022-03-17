package everyday.longestWord;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 720. 词典中最长的单词 https://leetcode-cn.com/problems/longest-word-in-dictionary/
 * 哈希表
 */
class Solution {
    public String longestWord(String[] words) {
        String res = "";
        Arrays.sort(words);
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            // 如果符合条件，则将其放入哈希表中
            // 1.word长度==1
            // 2.word去掉最后一个单词在hash表中
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > res.length()) {
                    res = word;
                } else if (word.length() == res.length()) {
                    res = word.compareTo(res) < 0 ? word : res;
                }
            }
        }
        return res;
    }
}
