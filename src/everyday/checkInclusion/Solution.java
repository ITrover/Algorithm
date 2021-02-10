package everyday.checkInclusion;

/**
 * @author itrover
 * 567. 字符串的排列 https://leetcode-cn.com/problems/permutation-in-string/
 * 滑动窗口
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        boolean[] exist = new boolean[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            exist[s1.charAt(i) - 'a'] = true;
        }
        int cnt = 0;
        int left = 0;
        int right = 0;
        // 构造窗口
        for (; right < s1.length() - 1; right++) {
            int c = s2.charAt(right) - 'a';
            if (exist[c]) {
                count[c]--;
                if (count[c] >= 0) {
                    cnt++;
                }
            }
        }
        while (right < s2.length()) {
            int c = s2.charAt(right) - 'a';
            if (exist[c]) {
                count[c]--;
                if (count[c] >= 0) {
                    cnt++;
                }
            }
            if (cnt == s1.length()) {
                return true;
            }
            // 整个窗口右移
            int remove = s2.charAt(left) - 'a';
            if (exist[remove]) {
                count[remove]++;
                if (count[remove] > 0) {
                    cnt--;
                }
            }
            right++;
            left++;
        }
        return false;
    }
}
