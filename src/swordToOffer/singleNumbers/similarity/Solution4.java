package swordToOffer.singleNumbers.similarity;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/10/19 18:19
 * @description
 * 位运算
 * 分别计算每一位
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution4 {
    public int singleNumber(int[] nums) {
        int res = 0;
        // 为每一位赋值
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                // num 的第i位为1
                if (((num >>> i) & 1) == 1) {
                    cnt++;
                }
            }
            // 第i位出现的次数余3为1
            if (cnt % 3 == 1){
                // 使用^对第i位赋值
                res ^= (1 << i);
            }
        }
        return res;
    }
}
