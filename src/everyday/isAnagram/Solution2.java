package everyday.isAnagram;

/**
 * @author itrover
 * 42. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 * 利用字母只有26个使用数组代替hash
 */
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] tab = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tab[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tab[t.charAt(i) - 'a']--;
            if (tab[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
