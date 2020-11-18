package everyday.canCompleteCircuit;

/**
 * @author itrover
 * 134. 加油站 https://leetcode-cn.com/problems/gas-station/
 * 如果存在解，该解一定在累计消耗最大的后一个位置
 */
class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}
