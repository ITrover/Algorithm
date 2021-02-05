package everyday.arrayStringsAreEqual;

/**
 * @author itrover
 * 1662. 检查两个字符串数组是否相等 https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent/
 */
class Solution2 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return getStr(word1).equals(getStr(word2));
    }

    private String getStr(String[] word) {
        StringBuilder sb = new StringBuilder();
        for (String s : word) {
            sb.append(s);
        }
        return sb.toString();
    }
}
