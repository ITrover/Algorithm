package leetcode.PalindromeNumber;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/6/17 11:52
 */

public class Solution3 {
    public boolean isPalindrome(int x) {
        // 取出后半段数字进行翻转。
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            // 负数 或 以0结尾同时又不是0 的数一定不是回文数
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            // 将x拆成两半同时反转
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 偶数位的数，反过来一定是相同位数的。奇数位的，需要去除中间那个数
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
