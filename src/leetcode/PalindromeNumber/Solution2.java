package leetcode.PalindromeNumber;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/6/17 11:44
 */

class Solution2 {
    public boolean isPalindrome(int x) {
        // 使用数学方法，通过余和除，每次获得首尾的数，进行对比
        if (x < 0) {
            // 如果为负数，则一定不是回文数
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            // 获取与x相同位数的数
            div *= 10;
        }
        while (x > 0) {
            // 获取左边的数
            int left = x / div;
            // 获取右边的数
            int right = x % 10;
            if (left != right) {
                return false;
            }
            // 去除首尾的数字
            x = (x % div) / 10;
            // 由于x少了两位，所以div也少两位
            div /= 100;
        }
        return true;
    }
}
