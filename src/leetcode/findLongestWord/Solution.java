package leetcode.findLongestWord;

import java.util.List;

/**
 * @author itrover
 * 524. 通过删除字母匹配到字典里最长单词 https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * 双指针
 * 时间复杂度o(m*n) m为d的大小，n为s的长度
 */
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            // 剪枝，当当前目标子字符串长度小于longestWord或者长度相等但是大于了longestWord，则不比较
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                // j只有相等时才移动
                j++;
            }
            // i始终向前移动
            i++;
        }
        // 如果是字串，则长度相等
        return j == target.length();
    }
}
