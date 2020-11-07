package everyday.countRangeSum;

/**
 * @author itrover
 * 327. 区间和的个数 https://leetcode-cn.com/problems/count-of-range-sum/
 * 暴力破解
 * 时间复杂度o(n^2)
 * 超时
 */
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (valid(nums[i], lower, upper)) {
                res++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (valid(countRange(nums, i, j), lower, upper)) {
                    res++;
                }
            }
        }
        return res;
    }

    long countRange(int[] nums, int start, int end) {
        long res = 0L;
        for (int i = start; i <= end; i++) {
            res += nums[i];
        }
        return res;
    }

    boolean valid(long count, int lower, int upper) {
        return count >= lower && count <= upper;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647},-564,3864);
    }

}
