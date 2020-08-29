package swordToOffer.firstUniqChar;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 *  使用有序哈希表
 *      时间复杂度o(n)
 *      空间复杂度o(1)
 * @date 2020/8/23 16:07
 */
class Solution2 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        // 由于是按照插入顺序排序的
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) {
                return d.getKey();
            }
        }
        return ' ';
    }
}
