package swordToOffer.isStraight;

import java.util.Arrays;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 *             剑指 Offer 61. 扑克牌中的顺子
 *             考点：理解能力，问题分析能力
 *             判断0的个数，是否大于或等于，排序后的数组中，每个非0数字之间的间隔数。
 *             当数组中出现两个非0且相等的数字时，出现了对子，则一定不能构成顺子。
 * @date 2020/8/10 21:16
 */
class Solution {
    public boolean isStraight(int[] nums) {
        // 先排序再插空
        Arrays.sort(nums);
        // 用来记录0的个数
        int a = 0;
        // 用来记录差值的个数
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                a++;
            } else if (i - 1 >= 0) {
                // 这种太多if， 代码不是很规范
                if (nums[i - 1] != 0) {
                    if (nums[i - 1] == nums[i]){
                        // 出现对子，不可能是顺子
                        return false;
                    }
                    b += nums[i] - nums[i - 1] - 1;
                }
            }
        }
        return a >= b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isStraight(new int[]{1, 2, 3, 5, 4});
    }
}
