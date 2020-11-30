package swordToOffer.sumNums;

/**
 * @author itrover
 * 剑指 Offer 64. 求1+2+…+n https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 技巧性、&&短路的利用
 */
class Solution {
    int res = 0;

    public int sumNums(int n) {
        // 利用 && 代替 if （短路）
        // 利用 > 将整数转变为boolean
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumNums(9));
    }

}
