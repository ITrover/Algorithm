package swordToOffer.minArray;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/23 20:24
 */
/**
 * 二分查找
 * 时间复杂度 o(log(n))
 * 空间复杂度 o(1)
 */
public class Solution2 {

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            // m在前半部分
            if (numbers[m] > numbers[j]) {
                i = m + 1;
                // m在后半部分
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                // 无法确认选择点在那个区间
                // 所以缩小查找范围
                // 同时保证查找点在区间【i，j】
                j--;
            }
        }
        return numbers[i];
    }

}
