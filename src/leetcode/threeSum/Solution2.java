package leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/6/17 13:11
 * 15. 三数之和 https://leetcode-cn.com/problems/3sum/
 * 双指针
 */
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序 , 由小到大
        // 先定一个数，然后用指针去找后面另外两个数
        // 时间复杂度 o(n^2)
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0){
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果当前的数大于0 则退出
            if (nums[i] > 0) {
                break;
            }
            // 如果当前的数等于之前的数，则继续（重复了）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    // 相等，则添加
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 排除相同的数
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    ++j; --k;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {-1, 0, 1, 2, 2, -4};
        System.out.println(solution2.threeSum(nums));
    }
}
