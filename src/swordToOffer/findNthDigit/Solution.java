package swordToOffer.findNthDigit;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 找规律的题
 */
class Solution {
    public int findNthDigit(int n) {
        // 区间位数
        int digit = 1;
        // 区间开始的数字
        long start = 1;
        // 每个区间对应的个数
        long count = 9;
        // 找到数字对应的区间
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 找到数字
        long num = start + (n - 1) / digit;
        // 定位数字的位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
