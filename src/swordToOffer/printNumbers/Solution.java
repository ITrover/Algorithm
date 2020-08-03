package swordToOffer.printNumbers;

import java.util.Arrays;

/**
 * 确认n位的最大数
 * 然后遍历输出
 * 时间复杂度 o(10^n)
 * 题型 ：
 *      数组
 */
class Solution {
    public int[] printNumbers(int n) {
        //构建最大数
        int max = 0;
//        for (int i = 0; i < n; i++) {
//            max += 9*Math.pow(10,i);
//        }

        max = (int) (Math.pow(10, n) - 1);
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = solution.printNumbers(2);
        System.out.println(Arrays.toString(numbers));
    }
}
