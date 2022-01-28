package leetcode.swapNumbers;

/**
 * @author itrover
 * 面试题 16.01. 交换数字 https://leetcode-cn.com/problems/swap-numbers-lcci/
 * 异或
 */
class Solution {
    public int[] swapNumbers(int[] numbers) {
        // a^b^b = a
        // a = a^b
        numbers[0] = numbers[0]^numbers[1];
        // b = a^b^b = a
        numbers[1] = numbers[0]^numbers[1];
        // a = a^b^a = b
        numbers[0] = numbers[0]^numbers[1];
        return numbers;
    }
}
