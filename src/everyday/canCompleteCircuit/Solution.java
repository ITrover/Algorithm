package everyday.canCompleteCircuit;

/**
 * @author itrover
 * 134. 加油站 https://leetcode-cn.com/problems/gas-station/
 * 同Solution3，这里是作为起点的，都循环了一圈
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            // 以i为起点，判断是否能够跑完一圈
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                // 累计消耗大于了总的油量
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            // 跑完了一圈
            if (cnt == n) {
                return i;
            } else {
                // 从[i,i + cnt]都不可以成为起点
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
