package everyday.kClosest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author itrover
 * 973. 最接近原点的 K 个点 https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * 简化代码
 * 时间复杂度o(nlog(n))
 * 空间复杂度o(1)
 */
class Solution3 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0] * a[0] + a[1] * a[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}
