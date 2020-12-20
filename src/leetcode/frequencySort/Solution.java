package leetcode.frequencySort;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author itrover
 * 451. 根据字符出现频率排序 https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 哈希表 + 堆
 */
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 通过哈希表记录字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // 大顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        map.forEach((k, v) -> queue.add(new int[]{k, v}));
        StringBuilder sb = new StringBuilder();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] item = queue.poll();
            if (item[1] == 0) {
                break;
            }
            for (int j = 0; j < item[1]; j++) {
                sb.append((char) (item[0]));
            }
        }
        return sb.toString();
    }
}
