package leetcode.LongestSubstring;//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

/**
 * 还有滑动窗口解法
 * 未完
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 从头滑动，直到出现相同字符，停止
        // 记录当前最大字串长度
        // 移动起始位置，重复操作
        int length = s.length();
        //空串返回0，如果字符串大于0，最小不重复字串一定为1
        if (length > 0) {
            int max = 1;
            int theMax = 1;
            int start = 0;
            for (int i = 1; i < length; i++) {
                // 此处可优化，当max > length - start 时，就一定没有更长的字串了，所以退出
                theMax = 1;
                // 判断当前字符（i位置）是否能够与前面无重复字符重复
                for (int j = start; j < i; j++) {
                    if (s.charAt(j) != s.charAt(i)) {
                        // 和之前的字符不同，所以最大字串长度+1
                        theMax++;
                    } else {
                        //出现相同字符，所以此次循环
                        //开始的位置移动到第一次出现相同字符的位置后面
                        start = j + 1;
                        break;
                    }
                }
                if (theMax > max) {
                    max = theMax;
                }
            }
            return max;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abcaba");
    }
}
