package everyday.coinChange;

import java.util.Arrays;

/**
 * dfs
 * 指数复杂度，每一层都是k个树的结点，每个结点下面又是k个树，k^(amount)
 * 自上而下
 * 超时
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int res = dfs(amount, coins);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int dfs(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            // 寻找i - coin的最优解
            if (coin <= amount) {
                res = Math.min(res, dfs(amount - coin, coins));
            }
        }
        // 如果找到了，则结果加上自身的1
        return res == Integer.MAX_VALUE ? Integer.MAX_VALUE : res + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }
}
