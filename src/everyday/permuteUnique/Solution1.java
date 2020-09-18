package everyday.permuteUnique;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author itrover
 * 47. 全排列 II(https://leetcode-cn.com/problems/permutations-ii/)
 */
class Solution1 {


    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0, used,new ArrayDeque<Integer>(),res);
        return res;
    }

    void dfs(int[] nums, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res){
        if (depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            // 减枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, used, path, res);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.permuteUnique(new int[]{1,1,2});
    }
}