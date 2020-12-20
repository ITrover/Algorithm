package leetcode.frequencySort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/12/20 12:50
 * 451. 根据字符出现频率排序 https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 哈希 + 桶排序
 */
public class Solution2 {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>((int) (s.length() / 0.75 + 1));
        for (char c : s.toCharArray()) {
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }

        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()) {
            // 用出现次数作为桶的序号,字符出现的次数在[0, s.length()]范围内
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
