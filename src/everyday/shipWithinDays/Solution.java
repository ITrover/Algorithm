package everyday.shipWithinDays;

import java.util.Arrays;

/**
 * @author itrover
 * 1011. 在 D 天内送达包裹的能力 https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * 二分查找
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // 确定二分查找左右边界
        // 最小的载重能力就是最大的那个包裹
        // 最大的载重能力就是一次性把所有包裹都运送过去
        // [一次只在一个货物需要的载重量， 全部运完的载重量]
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    // 安排在下一天运送了
                    cur = 0;
                }
                cur += weight;
            }
            // 需要少于等等于D天，那么载重能力可以减小
            if (need <= D) {
                right = mid;
            } else {
                // 需要大于D天，那么载重能力需要增大
                left = mid + 1;
            }
        }
        return left;
    }
}
