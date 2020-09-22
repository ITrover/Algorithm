package tencent.longestCommonPrefix;

/**
 * 14. 最长公共前缀(https://leetcode-cn.com/problems/longest-common-prefix/)
 * 从头开始比较字符串的首部
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int i = 0;
        // 纵向对比
        while (equal(strs, i)) {
            i++;
        }
        return strs[0].substring(0, i);
    }

    boolean equal(String[] strs, int i) {
        for (String str : strs) {
            if (str.length() < i + 1 || str.charAt(i) != strs[0].charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"abc"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}