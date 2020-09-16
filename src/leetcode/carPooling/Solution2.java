package leetcode.carPooling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/15 22:09
 * @description 1094. 拼车 (https://leetcode-cn.com/problems/car-pooling/)
 * 统计每一段路的负载
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
public class Solution2 {
    public boolean carPooling(int[][] trips, int capacity) {
        // 线路从0 到 1000
        int[] allTrip = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                // trips[i][1]上车到trips[i][2]下车这段路的载客量都增加
                allTrip[j] += trips[i][0];
                if (allTrip[j] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        int[][] trap = new int[][]{{2, 1, 5}, {3, 3, 7}};
//        int[][] trap = new int[][]{{3,2,7}, {3,7,9},{8,3,9}};
        int[][] trap = new int[][]{{3, 5, 9}, {4, 2, 5}, {3, 4, 6}, {9, 1, 4}, {5, 6, 8}, {5, 4, 6}};

        System.out.println(solution.carPooling(trap, 14));
    }
}
