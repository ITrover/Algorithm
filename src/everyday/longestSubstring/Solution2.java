package everyday.longestSubstring;

/**
 * @author itrover
 * 395. 至少有 K 个重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 滑动窗口，枚举字符种类数量
 */
class Solution2 {
    public int longestSubstring(String s, int k) {
        int ret = 0;
        int n = s.length();
        // 枚举字符种类数量
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];
            // 子字符串中包含的字符种类
            int tot = 0;
            // 子字符串中不满足的字符数量
            int less = 0;
            while (r < n) {
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[s.charAt(r) - 'a'] == k) {
                    // 有的字符满足了条件
                    less--;
                }
                // 字符串中的字符种类数，大于了给定的数量
                // 需要从左边删除
                while (tot > t) {
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                // 子字符串中的所有字符都满足条件
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}
