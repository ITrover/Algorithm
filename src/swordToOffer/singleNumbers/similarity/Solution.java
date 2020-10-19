package swordToOffer.singleNumbers.similarity;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * ①有限状态机
 * 出现一次的数的特点：该数的任意一位在所有数中出现的次数不是3的倍数
 * 余3
 * ②出现次数与3的余数分别为0 1 2
 * 对于任意一位可以用两位数来表示出现的次数 0 -> 1 -> 2 -> 0 -> 1 .....
 *                        对应的数字位：00 -> 01 -> 10 -> 00 -> 01....
 * ③位运算
 * 计算状态转移
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
