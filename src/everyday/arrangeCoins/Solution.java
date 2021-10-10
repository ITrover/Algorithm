package everyday.arrangeCoins;

/**
 * @author itrover
 * 441. 排列硬币 https://leetcode-cn.com/problems/arranging-coins/
 * 求根
 */
class Solution {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt((long) 8 * n + 1) - 1) / 2;
    }
}
