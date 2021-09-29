package everyday.findMinMoves;

import java.util.Arrays;

/**
 * @author itrover
 * 517. 超级洗衣机 https://leetcode-cn.com/problems/super-washing-machines/
 * 贪心
 */
class Solution {
    public int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        int n = machines.length;
        if (sum % n != 0) {
            return -1;
        }
        int avg = sum / n;
        int res = 0;
        int presum = 0;
        for (int num : machines) {
            // 当前与avg的差
            num -= avg;
            // 前面i个与avg差的总和
            presum += num;
            res = Math.max(res, Math.max(Math.abs(presum), num));
        }
        return res;
    }
}
