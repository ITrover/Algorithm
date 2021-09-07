package leetcode.balancedStringSplit;

/**
 * @author itrover
 * 1221. 分割平衡字符串 https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 */
class Solution {
    public int balancedStringSplit(String s) {
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                cnt--;
            } else {
                cnt++;
            }
            if (cnt == 0) {
                res++;
            }
        }
        return res;
    }
}
