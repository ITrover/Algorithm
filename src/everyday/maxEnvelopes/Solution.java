package everyday.maxEnvelopes;

import java.util.Arrays;

/**
 * @author itrover
 * 354. 俄罗斯套娃信封问题 https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 动态规划
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 这里需要注意
        // 当前面个的宽 == 后面个的宽时，那么要把大的放在前面，都不符合条件
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            // 从前面到现在，保留最大的
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }
}
