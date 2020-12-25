package leetcode.isSubsequence;

/**
 * @author itrover
 * 392. 判断子序列 https://leetcode-cn.com/problems/is-subsequence/
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            // 都找到了
            if (index == s.length()){
                return true;
            }
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
        }
        return index == s.length();
    }
}
