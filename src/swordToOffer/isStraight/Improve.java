package swordToOffer.isStraight;

import java.util.Arrays;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/8/10 21:32
 */
public class Improve {
    public boolean isStraight(int[] nums) {
        // 先排序再插空
        Arrays.sort(nums);
        // 用来记录0的个数
        int a = 0;
        // 用来记录差值的个数
        int b = 0;
        // 统计0的个数
        for (int i = 0; i < nums.length && nums[i] == 0; i++) {
            a++;
        }
        // 计算间隔，若出现相同数字则返回false
        for (int i = a + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
            b += nums[i] - nums[i - 1] - 1;
        }
        return a >= b;
    }

}
