package everyday.platesBetweenCandles;

/**
 * 2055. 蜡烛之间的盘子 https://leetcode-cn.com/problems/plates-between-candles/
 * 预处理 + 前缀和
 */
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        // 前缀和，确认盘子数量
        // 使用数组记录左右最近蜡烛
        int n = s.length();
        int[] preSum = new int[n + 1];
        int[] left = new int[n];
        int l = -1;
        int[] right = new int[n];
        int r = -1;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = (s.charAt(i) == '*' ? 1 : 0) + preSum[i];
            if (s.charAt(i) == '|') l = i;
            left[i] = l;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') r = i;
            right[i] = r;
        }
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int a = right[query[0]];
            int b = left[query[1]];
            if (a != -1 && b != -1 && b > a) {
                res[i] = preSum[b] - preSum[a];
            }
            i++;
        }
        return res;
    }
}
