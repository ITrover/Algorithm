package everyday.canCompleteCircuit;

/**
 * 134. 加油站 https://leetcode-cn.com/problems/gas-station/
 * 枚举
 * 以每个位位置为起点，逐一尝试
 * 时间复杂度o(n^2)
 *
 */
class Solution3 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (canCompleteCircuit(gas, cost, i)) {
                return i;
            }
        }
        return -1;
    }

    boolean canCompleteCircuit(int[] gas, int[] cost, int start) {
        int remain = 0;
        for (int i = start; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                return false;
            }
        }
        for (int i = 0; i < start; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                return false;
            }
        }
        return true;
    }
}
