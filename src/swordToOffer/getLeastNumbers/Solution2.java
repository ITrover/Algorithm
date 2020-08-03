package swordToOffer.getLeastNumbers;

import javafx.collections.transformation.SortedList;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/22 21:10
 */

public class Solution2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                // 堆中无数据，直接放入队中
                pq.offer(num);
            } else if (num < pq.peek()) {
                // 小的放入堆中，大的弹出。
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }
}
