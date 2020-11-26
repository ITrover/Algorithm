package everyday.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/20 17:08
 * @description
 * 递归
 */
public class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {
        //终止条件判断
        if (index == nums.length) {
            System.out.println(list);
            res.add(new ArrayList<>(list));
            return;
        }
        //每一个节点都有两个分支，一个选一个不选
        //走不选这个分支
        helper(res, nums, list, index + 1);
        //走选择这个分支
        list.add(nums[index]);
        helper(res, nums, list, index + 1);
        //撤销选择
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        solution.subsets(new int[]{1,2,3});
    }
}
