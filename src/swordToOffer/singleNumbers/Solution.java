package swordToOffer.singleNumbers;

/**
 * @author itrover
 * 剑指 Offer 56 - I. 数组中数字出现的次数 https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * 使用异或
 * 如果两个不同的数分别为 2（10） 3（11）
 * 那么最终异或出的结果为 1（01）
 * 两个数不一样的地方，就是二进制为1的位置
 * 通过与其他数分组异或，即可拆分出两个数
 */
class Solution {
    public int[] singleNumbers(int[] nums) {

        int number = 0;
        for (int num : nums) {
            number ^= num;
        }
        int div = 1;
        // 通过第一个不同的位置（即number从右到左，第一个1的位置），来区分两个数
        while ((div & number) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) > 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }


}
