package everyday.kClosest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author itrover
 * 973. 最接近原点的 K 个点 https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * 使用堆
 */
class Solution2 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> dis = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < points.length; i++) {
            int[] distance = new int[2];
            distance[0] = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            distance[1] = i;
            dis.add(distance);
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = points[dis.poll()[1]];
        }
        return res;
    }
}
