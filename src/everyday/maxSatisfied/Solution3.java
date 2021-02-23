package everyday.maxSatisfied;

/**
 * @author itrover
 * 1052. 爱生气的书店老板 https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * 滑动区间
 */
class Solution3 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int n = customers.length;
        // 满意的数量
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        // 能增加的就是不满意的数量
        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        // 贪心算法，子数组的最大值
        for (int i = X; i < n; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }
}
