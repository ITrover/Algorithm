package everyday.findMinArrowShots;

import java.util.Arrays;

/**
 * @author itrover
 * 452. 用最少数量的箭引爆气球 https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 更加简洁的写法
 * 通过数组的末尾排序，末尾递增排列
 * 通过前一个的末尾和后一个的开头比较，如果后一个的开头在前一个的末尾前那么一定可以被一起射中
 */
class Solution2 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        int res = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                res++;
                pre = points[i][1];
            }
        }
        return res;
    }
}
