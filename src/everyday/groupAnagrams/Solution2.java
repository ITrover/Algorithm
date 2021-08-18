package everyday.groupAnagrams;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
 * 通过计数构建一个**按照字符顺序排列的字符串**作为key
 * 时间复杂度o(n*k)
 * 空间复杂度o(nk)
 */
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i) - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt.length; i++) {
                for (int j = 0; j < cnt[i]; j++) {
                    sb.append((char) (i + 'a'));
                }
            }
            String key = sb.toString();
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }
}
