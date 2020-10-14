package everyday.commonChars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author itrover
 * 1002. 查找常用字符 https://leetcode-cn.com/problems/find-common-characters/
 * 计数统计，每次保存每个字符出现最少的次数
 */
class Solution {
    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        Arrays.fill(count,Integer.MAX_VALUE);
        for (String s : A) {
            int[] tmp = new int[26];
            for (int i = 0; i < s.length(); i++) {
                tmp[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                count[i] = Math.min(count[i],tmp[i]);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
