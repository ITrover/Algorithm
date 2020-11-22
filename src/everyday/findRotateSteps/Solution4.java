package everyday.findRotateSteps;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author itrover
 * 动态规划，找到上一个位置，到当前每一个可能位置的最近的步数
 * 时间复杂度o(mn^2)
 */
class Solution4 {

    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        // 将ring中每个字符对应的位置用list保存
        for (int i = 0; i < n; ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        // dp[i][j]代表从前往后拼出key的第i个字符，ring的第j个字符位于12点方向的最小步数
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            // 0x3f3f3f3f相当于最大值,10^9级，和Integer.MAX_VALUE同数量级
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            // key第一个字符，需要调整的最小步数
            // 对于ring中的每一个字母，要么是顺时针到达，要么是逆时针到达
            // 取最近的方向
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                // 计算从上一步到这一步的最短路径，多个起点，多个终点，分别找到最短路径
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    // 到下一位置分为顺时针和逆时针，使用最少步数的方向
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        // 最后一行的最小数，即为最小步数
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
