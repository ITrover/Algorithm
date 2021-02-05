package everyday.arrayStringsAreEqual;

/**
 * @author itrover
 * 1662. 检查两个字符串数组是否相等 https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent/
 */
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int ii = 0, ij = 0;
        if (getLength(word1) != getLength(word2)) {
            return false;
        }
        while (i < word1.length && j < word2.length) {
            while (ii < word1[i].length() && ij < word2[j].length()) {
                if (word1[i].charAt(ii) != word2[j].charAt(ij)) {
                    return false;
                }
                ii++;
                ij++;
            }
            if (ii == word1[i].length()) {
                i++;
                ii = 0;
            }
            if (ij == word2[j].length()) {
                j++;
                ij = 0;
            }
        }
        return i == word1.length && j == word2.length;
    }

    private int getLength(String[] word) {
        int res = 0;
        for (String s : word) {
            res += s.length();
        }
        return res;
    }
}
