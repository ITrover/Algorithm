package everyday.minimumOperations;

/**
 * @author itrover
 * LCP 19. 秋叶收藏集 https://leetcode-cn.com/problems/UlBDOe/
 * 动态规划
 * 时间复杂度o(n)
 * 0 首部的红色 红
 * 1 中间的黄色 红黄
 * 2 尾部的红色 红黄红
 */
class Solution {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        // 表示从[0,i]，同时叶子的状态为j的最小操作次数
        int[][] f = new int[n][3];
        // 初始化
        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        // 不可能出现的情况，即第一不能为黄色或最后的红色，第二个不能为组后的红色
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
        // 状态转移规则
        for (int i = 1; i < n; ++i) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            // [0,i]全是红色，需要从上一个前端红色状态 + 把当前变为红色
            f[i][0] = f[i - 1][0] + isYellow;
            // [0,i]是红黄，可以从上一个红色和上一个黄色变化过来，比较谁操作次数更少
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
            if (i >= 2) {
                // [0,i]是红黄红，可以从上一个黄色和上一个是末尾红色变化过来
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
            }
        }
        // 结果只能是红黄红
        return f[n - 1][2];
    }
}
