package everyday.combinationSum;

import java.util.*;

/**
 * @author itrover
 * @date 2020/9/9 19:00
 * 39. 组合总和
 * 同combine题相近
 * 深度优先，回溯，减枝
 * 速度大量提升 55% -> 87%
 */
class Solution2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0){
            return res;
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(0,target,candidates,path,res);
        return res;
    }

    /**
     *
     * @param start 候选值开始的位置
     * @param target 目标值
     * @param candidates 候选值
     * @param path 路径
     * @param res 结果
     */
    void dfs(int start, int target, int[] candidates, Deque<Integer> path, List<List<Integer>> res){
        // 满足条件添加到结果
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 减枝
            if (candidates[i] > target){
                break;
            }
            path.addLast(candidates[i]);
            // 由于同一个数可以使用很多次，所以开始的位置还是i
            dfs(i,target - candidates[i], candidates, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}