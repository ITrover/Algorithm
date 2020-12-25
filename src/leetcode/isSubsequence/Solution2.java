package leetcode.isSubsequence;

/**
 * @author itrover
 * 392. 判断子序列 https://leetcode-cn.com/problems/is-subsequence/
 */
class Solution2 {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
