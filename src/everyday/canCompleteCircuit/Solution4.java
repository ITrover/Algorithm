package everyday.canCompleteCircuit;

/**
 * 贪心算法
 * 134. 加油站 https://leetcode-cn.com/problems/gas-station/
 */
class Solution4 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        // 从0开始的累计剩余
        int totalRemain = 0;
        // 以res为起点的当前累计剩余
        int remain = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            totalRemain += gas[i] - cost[i];
            remain += gas[i] - cost[i];
            // 如果当前累计剩余小于0，那么之前那一段不能成为起点
            if (remain < 0) {
                remain = 0;
                res = i + 1;
            }
        }
        return totalRemain >= 0 ? res : -1;
    }
}
