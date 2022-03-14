package leetcode.fourSum;

import java.util.*;

/**
 * @author itrover
 * 18. 四数之和 https://leetcode-cn.com/problems/4sum/
 * 遍历暴力 + 优化的递归版本
 */
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        recur(nums, 0, target, 0, new ArrayDeque<>(4));
        return res;
    }

    private void recur(int[] nums, int index, long target, int k, Deque<Integer> deque) {
        if (k == 4) {
            if (target == 0) {
                res.add(new ArrayList<>(deque));
            }
            return;
        }
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // 避免重复
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // 剪枝
            if (i < nums.length - 1 && target - nums[i] - (3 - k) * (long)nums[i + 1] < 0) {
                return;
            }
            // 当前的数太小了
            if (i < nums.length - 1 && target - nums[i] - (3 - k) * (long)nums[nums.length - 1] > 0) {
                continue;
            }
            // 要么添加，要么不添加
            deque.push(nums[i]);
            recur(nums, i + 1, target - nums[i], k + 1, deque);
            deque.pop(); // offer push pop poll
        }
    }

    private boolean isEqual(List<Integer> list) {
        for (List<Integer> re : res) {
            if (isEqual(list, re)) return true;
        }
        return false;
    }

    private boolean isEqual(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]
                        {0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000},
                1000000000));
    }
}
