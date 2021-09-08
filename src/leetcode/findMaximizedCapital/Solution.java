package leetcode.findMaximizedCapital;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author itrover
 * 502. IPO https://leetcode-cn.com/problems/ipo/
 * 大顶堆、贪心算法
 */
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] tmp = new int[n][2];
        for (int i = 0; i < n; i++) {
            tmp[i][0] = capital[i];
            tmp[i][1] = profits[i];
        }
        int cur = 0;
        Arrays.sort(tmp, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            // 当前项目可启动，则启动
            while (cur < n && tmp[cur][0] <= w) {
                pq.add(tmp[cur][1]);
                cur++;
            }
            // 大顶堆，挑出当前收益允许的项目中最大收益的那个项目
            if (!pq.isEmpty()) {
                w += pq.poll();
            }else {
                break;
            }
        }
        return w;
    }
}
