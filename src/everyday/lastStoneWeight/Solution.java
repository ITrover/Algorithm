package everyday.lastStoneWeight;

import java.util.PriorityQueue;
/**
 * @author itrover
 * 1046. 最后一块石头的重量 https://leetcode-cn.com/problems/last-stone-weight/
 * 大顶堆
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.add(stone);
        }
        while(queue.size() > 1){
            // 只要queue的大小大于1，则每次取两个进行比较
            int left = queue.poll();
            int right = queue.poll();
            int leaf = Math.abs(right - left);
            if (leaf != 0){
                queue.add(leaf);
            }
        }
        return !queue.isEmpty() ? queue.poll() : 0;
    }
}
