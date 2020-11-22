package everyday.isAnagram;

import java.util.Arrays;
/**
 * @author itrover
 * 42. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 * 排序
 */
class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1,arr2);
    }
}
