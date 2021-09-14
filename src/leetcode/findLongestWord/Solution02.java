package leetcode.findLongestWord;

import java.util.Arrays;
import java.util.List;

/**
 * @author itrover
 * 524. 通过删除字母匹配到字典里最长单词 https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * 动态规划（类比kmp算法）
 */
class Solution02 {
    public String findLongestWord(String s, List<String> d) {
        int length = s.length();
        // index[i][j]表示，s[i]后第一次出现'a'+j的位置
        int[][] index = new int[length + 1][26];
        Arrays.fill(index[length], length);
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == 'a' + j) {
                    index[i][j] = i;
                } else {
                    index[i][j] = index[i + 1][j];
                }
            }
        }
        String res = "";
        for (String str : d) {
            // 剪枝
            if (res.length() > str.length() || (res.length() == str.length() && res.compareTo(str) < 0)) {
                continue;
            }
            int j = 0;
            boolean match = true;
            for (int i = 0; i < str.length(); i++) {
                // 当前位置j，查第一次出现i的位置
                j = index[j][str.charAt(i) - 'a'];
                if (j == length) {
                    match = false;
                    break;
                }
                j += 1;
            }
            if (match) {
                res = str;
            }
        }
        return res;
    }
}
