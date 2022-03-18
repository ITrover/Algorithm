package swordToOffer.strToInt;

/**
 * @author itrover
 * 剑指 Offer 67. 把字符串转换成整数 https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * 遍历
 * 时间复杂度o(n)
 */
class Solution {
    public int strToInt(String str) {
        int i = 0;
        int n = str.length();
        // 去除空格
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n || (str.charAt(i) != '+' && str.charAt(i) != '-' && !Character.isDigit(str.charAt(i)))) {
            return 0;
        }
        long num = 0;
        int sign = 1;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        // 连续数字
        while (i < n && Character.isDigit(str.charAt(i))) {
            num *= 10;
            num += str.charAt(i) - '0';
            if (sign == 1) {
                if (num > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (num > (long) Integer.MAX_VALUE + 1) {
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }
        return (int)(sign * num);
    }
}
