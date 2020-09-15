package leetcode.carPooling;

import java.util.*;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/15 22:09
 * @description 1094. 拼车 (https://leetcode-cn.com/problems/car-pooling/)
 * 模拟顺风车的行驶过程
 * 时间复杂度o(n*length(passenger))
 */
public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips.length == 0){
            return true;
        }
        // 先按照上车地点排序，然后遍历
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        // 这个就相当于顺风车
        ArrayList<Integer> passenger = new ArrayList<>();
        for (int i = 0; i < trips.length; i++) {
            // 判断之前的乘客是否可以下车
            Iterator<Integer> iterator = passenger.iterator();
            while(iterator.hasNext()){
                int tmp = iterator.next();
                // 如果当前的上车地址，大于现有乘客的下车地址
                // 则下车
                if (trips[i][1] >= trips[tmp][2]){
                    // 下车
                    iterator.remove();
                }
            }
            // 当前乘客上车
            passenger.add(i);
            // 统计当前车上的人数
            int capNow = 0;
            for (Integer integer : passenger) {
                capNow += trips[integer][0];
            }
            if (capNow > capacity){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] trap = new int[][]{{2, 1, 5}, {3, 3, 7}};
//        int[][] trap = new int[][]{{3,2,7}, {3,7,9},{8,3,9}};
        int[][] trap = new int[][]{{3,5,9}, {4,2,5},{3,4,6},{9,1,4},{5,6,8},{5,4,6}};

        System.out.println(solution.carPooling( trap, 14));
    }
}
