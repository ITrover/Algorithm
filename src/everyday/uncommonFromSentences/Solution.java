package everyday.uncommonFromSentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 884. 两句话中的不常见单词 https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 * 哈希表
 */
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        fillMap(s1, map);
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }

    private void fillMap(String s1, Map<String, Integer> map) {
        String[] s1Words = s1.split(" ");
        for (String s1Word : s1Words) {
            Integer cnt = map.getOrDefault(s1Word, 0);
            map.put(s1Word, cnt + 1);
        }
    }
}
