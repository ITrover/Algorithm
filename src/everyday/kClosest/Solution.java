package everyday.kClosest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author itrover
 * 973. 最接近原点的 K 个点 https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * 先求距离再排序
 * 时间复杂度o(nlog(n))
 * 空间复杂度o(n))
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] dis = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            dis[i][0] = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            dis[i][1] = i;
        }
        Arrays.sort(dis, Comparator.comparingInt(a -> a[0]));
        int[][] res = new int[K][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = points[dis[i][1]];
        }
        return res;
    }
}
