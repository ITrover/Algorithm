package leetcode.findDifferentBinaryString;

import java.util.Arrays;

/**
 * 1980. 找出不同的二进制字符串 https://leetcode-cn.com/problems/find-unique-binary-string/
 * 排序
 */
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        char[] number = new char[nums[0].length()];
        Arrays.fill(number, '0');
        if (!nums[0].equals(new String(number))) {
            return new String(number);
        }
        for (int i = 1; i < nums.length; i++) {
            int a = Integer.parseInt(nums[i], 2);
            int b = Integer.parseInt(nums[i - 1], 2);
            if (a != b + 1) {
                StringBuilder res = new StringBuilder(Integer.toBinaryString(b + 1));
                // 补0
                while (res.length() < number.length) {
                    res.insert(0, "0");
                }
                return res.toString();
            }
        }
        Arrays.fill(number, '1');
        return new String(number);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDifferentBinaryString(new String[]{"0000000000001001", "0000000000000001", "1111111111111111", "0000000000000100", "0000000000001110", "0000000000001011", "0000000000001100", "0000000000000010", "0000000000001111", "0000000000000110", "0000000000001000", "0000000000001101", "0000000000000111", "0000000000000101", "0000000000000000", "0000000000001010"}));
    }
}
