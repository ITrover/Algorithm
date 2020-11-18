package everyday.combinationSum.improve;

import java.util.*;

/**
 * @author itrover
 * 40. 组合总和 II https://leetcode-cn.com/problems/combination-sum-ii/
 * 回溯 + 减枝
 */
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        // 这是后面剪枝的关键
        Arrays.sort(candidates);
        dfs(candidates, target, 0, deque, res);
        return res;
    }

    void dfs(int[] candidates, int target, int start,
             Deque<Integer> deque,
             List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 在同一层进行剪枝，即从[start,candidates.length)
            // 如果当前的数和前面的相同，则跳过
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target >= candidates[i]) {
                deque.addLast(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, deque, res);
                // 回溯
                deque.pollLast();
            } else {
                // 由于是排过序的，所后面的肯定不满足条件
                break;
            }
        }
    }
}
