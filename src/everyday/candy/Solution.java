package everyday.candy;

/**
 * @author itrover
 * 135. 分发糖果 https://leetcode-cn.com/problems/candy/
 * 贪心算法，这种题最好是先画个图
 * 从图中可以看到，每个人给的糖果：为以他为山峰，左右分别向中间递增的最大长度 + 1（或者也可以表述为，左右递增序列的前一个的最大值 + 1），
 * 最坏情况o(n^2)
 */
class Solution {
    public int candy(int[] ratings) {
        if(ratings.length <= 1){
            return ratings.length;
        }
        int res = ratings[0] > ratings[1] ? 2 : 1;
        int[] dp = new int[ratings.length];
        dp[0] = res;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] <= ratings[i - 1]){
                // 当前小于前一个，则变为1
                dp[i] = 1;
                int j = i - 1;
                // 后面个影响前面一个
                // TODO: 2020/12/24 可优化
                // 如果前面个比当前大，同时给的糖果不大于当前，则需要给他添加
                // 这个会导致连锁反应，即递减数组，会一直往前去更新
                while(j >= 0 && ratings[j] > ratings[j + 1] && dp[j] <= dp[j + 1]){
                    res -= dp[j];
                    dp[j] = dp[j + 1] + 1;
                    res += dp[j];
                    j--;
                }
            }else {
                // 当前大于前一个
                dp[i] = dp[i - 1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
