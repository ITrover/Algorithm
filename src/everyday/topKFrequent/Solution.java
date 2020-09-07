package everyday.topKFrequent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/7 19:47
 * @description 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 堆的使用,插入或删除时间复杂度log(k)
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 统计出现次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        // 每次把堆中最小的换掉
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k){
                if (queue.peek().getValue() < entry.getValue()){
                    queue.poll();
                    queue.offer(entry);
                }
            }else{
                queue.offer(entry);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

}
