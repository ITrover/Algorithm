package leetcode.langestpalindromic;//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

/**
 * 两个指针从中间分别向两边移动（分奇偶，开始点不同）
 * 知道两个字符串不相等，或者两个指针越界就停止
 * 如果是当前最大的，就用一个变量保存
 */
class Solution {
    public String longestPalindrome(String s) {
        // 分情况，奇回文，偶回文
        int length = s.length();
        int l, r;
        int max = 0;
        String ret = "";
        for (int i = 0; i < length; i++) {
            //可优化，如果已经找到最大的回文字符串，就可以退出了。
            //奇回文情况
            l = i;
            r = i;
            //从同一个位置向两边扩散
            while (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                if (l < 0 || r >= length) {
                    break;
                }
            }
            if (r - l - 1 > max) {
                max = r - l - 1;
                ret = s.substring(l + 1, r);
            }
            // 偶回文情况
            l = i - 1;
            r = i;
            //同两个相邻的字符向两边扩散
            while (l >= 0 && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                if (l < 0 || r >= length) {
                    break;
                }
            }
            if (r - l - 1 > max) {
                max = r - l - 1;
                ret = s.substring(l + 1, r);
            }
        }
        return ret;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
