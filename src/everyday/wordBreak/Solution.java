package everyday.wordBreak;


import java.util.*;

/**
 * @author itrover
 * 139. 单词拆分 https://leetcode-cn.com/problems/word-break/
 * 回溯
 */
class Solution {

    Set<String> set;

    Set<Integer> failedRemember = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>((int) (wordDict.size() / 0.75f + 1));
        int maxLen = -1, minLen = Integer.MAX_VALUE;
        // 统计最短和最长的单词
        for (String value : wordDict) {
            int len = value.length();
            if (len > maxLen) {
                maxLen = len;
            }
            if (len < minLen) {
                minLen = len;
            }
            set.add(value);
        }
        return recur(s, 0, maxLen, minLen);
    }

    /**
     * 匹配单词
     * 如果成功了，就继续调用该方法
     * 失败了，返回false
     * 上一个调用者，继续判断，是否有符合条件的单词，失败了，返回false\
     * 返回true，刚好匹配完毕
     *
     * @param s
     * @param start
     * @param maxLen
     * @param minLen
     * @return
     */
    boolean recur(String s, int start, int maxLen, int minLen) {
        // 到底了，都匹配成功了
        if (start >= s.length()) {
            return true;
        }
        // 记忆、减枝
        // 只要是这个位置进入的，就没有希望匹配成功
        if (failedRemember.contains(start)) {
            return false;
        }
        int i = minLen;
        String t;
        while (start + i <= s.length() && i <= maxLen) {
            t = s.substring(start, start + i);
            if (set.contains(t) && recur(s, start + i, maxLen, minLen)) {
                return true;
            }
            i++;
        }
        failedRemember.add(start);
        // 没有成功返回，就退出
        return false;
    }

    public static void main(String[] args) {
        String[] dictionary = {"a"};
        String s = "a";
        Solution so = new Solution();
        System.out.println(so.wordBreak(s, Arrays.asList(dictionary)));
    }

}
