package everyday.checkInclusion;

import java.util.Arrays;

/**
 * @author itrover
 * 567. 字符串的排列 https://leetcode-cn.com/problems/permutation-in-string/
 * 滑动窗口
 */
class Solution3 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            // 字符x + a多了，需要从左边移出去
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            // 窗口是n则条件符合
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}
