package everyday.subsetsWithDup;

import java.util.*;

/**
 * @author itrover
 * 90. 子集 II https://leetcode-cn.com/problems/subsets-ii/
 * 回溯
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(0, nums, deque, res);
        return res;
    }

    public void dfs(int index, int[] nums, Deque<Integer> deque, List<List<Integer>> res) {
        res.add(new ArrayList<>(deque));
        int i = index;
        while (i < nums.length) {
            deque.addLast(nums[i]);
            dfs(i + 1, nums, deque, res);
            int last = deque.pollLast();
            // 下次开始不能是相同的
            while (i < nums.length && last == nums[i]) {
                i++;
            }
        }
    }

}
