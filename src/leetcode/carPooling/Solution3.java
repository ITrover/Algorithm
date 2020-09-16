package leetcode.carPooling;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/15 22:09
 * @description 1094. 拼车 (https://leetcode-cn.com/problems/car-pooling/)
 * 统计上车和下车的人数变化
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
public class Solution3 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] capacityChange = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            // 统计上车和下车的人数变化
            capacityChange[trips[i][1]] += trips[i][0];
            capacityChange[trips[i][2]] -= trips[i][0];
        }
        int load = 0;
        for (int i = 0; i < capacityChange.length; i++) {
            load += capacityChange[i];
            if (capacity < load){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
//        int[][] trap = new int[][]{{2, 1, 5}, {3, 3, 7}};
//        int[][] trap = new int[][]{{3,2,7}, {3,7,9},{8,3,9}};
        int[][] trap = new int[][]{{3, 5, 9}, {4, 2, 5}, {3, 4, 6}, {9, 1, 4}, {5, 6, 8}, {5, 4, 6}};

        System.out.println(solution.carPooling(trap, 14));
    }
}
