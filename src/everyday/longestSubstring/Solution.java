package everyday.longestSubstring;

/**
 * @author itrover
 * 395. 至少有 K 个重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 分治法
 */
class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            // 字符i + 'a'的次数不满足条件
            // 子字符串中一旦出现i + 'a'则不满足条件
            // 合法的子字符串中一定不包含i + 'a'，以i + 'a'作为分割
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        // 所有字符都满足条件
        // 该字符串合法
        if (split == 0) {
            return r - l + 1;
        }
        int i = l;
        int ret = 0;
        while (i <= r) {
            // 跳过分割字符
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            // 无法构成字串了
            if (i > r) {
                break;
            }
            // 不包含split的区间
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            // 计算不包含split的区间满足条件的最大值
            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }
}
