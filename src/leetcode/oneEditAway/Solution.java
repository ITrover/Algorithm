package leetcode.oneEditAway;

/**
 * @author itrover
 * 面试题 01.05. 一次编辑 https://leetcode-cn.com/problems/one-away-lcci/
 * 分情况讨论
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        // 插入 删除 替换
        // 当长度相等时，只能替换
        // 当不等时，只能删除长的那个的字符或增加长度
        int len1 = first.length();
        int len2 = second.length();
        if (len1 == len2) {
            int k = 0;
            for (int i = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    k++;
                }
            }
            return k <= 1;
        }
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                // 不相等的那个字符，长的删除之
                // 对比字符串，如果相等，则可以
                return len1 > len2 ? first.substring(i + 1).equals(second.substring(i)) :
                        first.substring(i).equals(second.substring(i + 1));
            }
        }
        return true;
    }
}
