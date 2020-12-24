package everyday.candy;

import java.util.Arrays;

/**
 * @author itrover
 * 135. 分发糖果 https://leetcode-cn.com/problems/candy/
 * 贪心算法，两次遍历，取给糖果的最大值
 * 时间复杂度o(n)
 */
class Solution2 {
    class Solution {
        public int candy(int[] ratings) {
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);
            for(int i = 1; i < ratings.length; i++) {
                if(ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                }
            }
            int count = left[ratings.length - 1];
            for(int i = ratings.length - 2; i >= 0; i--) {
                if(ratings[i] > ratings[i + 1]) {
                    right[i] = right[i + 1] + 1;
                }
                count += Math.max(left[i], right[i]);
            }
            return count;
        }
    }
}
