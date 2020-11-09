package leetcode.addDigits;

/**
 * @author itrover
 * 258. 各位相加 https://leetcode-cn.com/problems/add-digits/
 * 递归
 */
class Solution {
    public int addDigits(int num) {
        // 只有个位则返回
        if (num < 10) {
            return num;
        }
        // 个位相加
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return addDigits(res);
    }
}
