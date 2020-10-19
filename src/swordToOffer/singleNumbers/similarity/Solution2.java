package swordToOffer.singleNumbers.similarity;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/10/19 16:44
 * @description
 * 循环
 * 位运算
 * 余3
 * 出现一次的数的特点：该数的任意一位在所有数中出现的次数不是3的倍数
 */
class Solution2 {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            // 统计int每一位为1出现的次数
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        // 对每一位出现1的次数余3，得到只出现一次的位
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
