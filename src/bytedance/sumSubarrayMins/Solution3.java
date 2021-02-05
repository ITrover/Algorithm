package bytedance.sumSubarrayMins;

import java.util.Stack;

/**
 * @author itrover
 * 907. 子数组的最小值之和 https://leetcode-cn.com/problems/sum-of-subarray-minimums/
 * 最小栈
 * 时间复杂度o(n)
 */
class Solution3 {
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;

        Stack<RepInteger> stack = new Stack();
        int ans = 0, dot = 0;
        for (int j = 0; j < A.length; ++j) {

            int count = 1;
            // 更新最小栈，更新从[0,j - 1]所有子数组最小值的和
            // 如果当前A[j]比之前的数小，那么从[0,j]包含j的子数组的最小值会改变
            while (!stack.isEmpty() && stack.peek().val >= A[j]) {
                RepInteger node = stack.pop();
                count += node.count;
                dot -= node.val * node.count;
            }
            stack.push(new RepInteger(A[j], count));
            // dot为从[0,j]所有子数组最小值的和
            dot += A[j] * count;
            ans += dot;
            ans %= MOD;
        }

        return ans;
    }
}

class RepInteger {
    int val, count;

    RepInteger(int v, int c) {
        val = v;
        count = c;
    }
}
