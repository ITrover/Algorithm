package swordToOffer.singleNumbers;

/**
 * 使用异或
 */
class Solution {
    public int[] singleNumbers(int[] nums) {

        int number = 0;
        for (int num : nums) {
            number ^= num;
        }

        int div = 1;
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
