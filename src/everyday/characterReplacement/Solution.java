package everyday.characterReplacement;

/**
 * @author itrover
 * 424. 替换后的最长重复字符 https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * 双指针，滑动窗口
 * 记录区间中出现最多的字符，同时当区间不满足条件时，移动区间
 * 将题中替换k次字符，转换为：除出现最多的字符外，区间中其他字符不能超过k个
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            int theChar = s.charAt(right) - 'A';
            num[theChar]++;
            // 区间内，出现最多的那个字符的数量
            maxn = Math.max(maxn, num[theChar]);
            // 如果其他字符超出了预期，则区间不符合条件
            if (right - left + 1 - maxn > k) {
                // 区间中左边字符的数量减少，因为区间右移了
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
