package everyday.maximumRequests;


import java.util.Arrays;

/**
 * @author itrover
 * 1601. 最多可达成的换楼请求数目 https://leetcode-cn.com/problems/maximum-number-of-achievable-transfer-requests/
 * 二进制枚举
 */
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        // delta[i]表示i号楼的净流入
        int[] delta = new int[n];
        int m = 1 << requests.length;
        int res = 0;
        // 枚举每一种可能的情况
        for (int mask = 1; mask < m; mask++) {
            int cnt = Integer.bitCount(mask);
            if (cnt <= res) {
                continue;
            }
            // 判断这次的请求序列是否符合条件
            Arrays.fill(delta, 0);
            for (int i = 0; i < requests.length; i++) {
                // 若第i为为1，则要这个请求
                if ((mask & (1 << i)) != 0) {
                    delta[requests[i][0]]--;
                    delta[requests[i][1]]++;
                }
            }
            // 若delta都不为0，则满足要求
            int z = res;
            res = cnt;
            for (int i : delta) {
                if (i != 0) {
                    res = z;
                    break;
                }
            }
        }
        return res;
    }
}
