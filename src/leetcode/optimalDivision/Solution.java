package leetcode.optimalDivision;

/**
 * @author itrover
 * 553. 最优除法 https://leetcode-cn.com/problems/optimal-division/
 * 数学+贪心
 */
class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < n; i++) {
            sb.append("/").append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }
}
