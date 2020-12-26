package leetcode.rob;

/**
 * @author itrover
 * 动态规划
 * 198. 打家劫舍 https://leetcode-cn.com/problems/house-robber/
 */
class Solution {
    public int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int num : nums) {
            // 当前的最大值为 Math.max(盗窃当前这个 + i - 2盗窃 , 昨天盗窃获得 i - 1)
            int cur = Math.max(pre2 + num, pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
