package swordToOffer.numWays;


class Solution {

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // 数组意义，每级台阶的跳法
        int[] ways = new int[n];
        // 初始值
        ways[0] = 1;
        ways[1] = 2;
        // 最小子结构，动态规划过程
        for (int i = 2; i < n; i++) {
            ways[i] = (ways[i - 1] + ways[i - 2]) % 1000000007;
        }
        return ways[n - 1];
    }
}
