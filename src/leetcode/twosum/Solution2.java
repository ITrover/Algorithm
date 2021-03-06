package leetcode.twosum;//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashMap;

/**
 * 查找表
 * 时间复杂度为 o(n)
 * 一遍遍历
 * 用一个hashmap来保存值和索引
 * 目标值减去当前数，用一个临时变量保存
 * 在hashmap找临时变量，返回索引，得出结果
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        //用来保存 值-索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement  = target - nums[i];
            Integer first = map.get(complement);
            if (first != null){
                return new int[]{i,first};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
