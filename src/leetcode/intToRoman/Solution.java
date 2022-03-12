package leetcode.intToRoman;

/**
 * @author itrover
 * 12. 整数转罗马数字 https://leetcode-cn.com/problems/integer-to-roman/
 * 枚举 贪心
 */
class Solution {
    public String intToRoman(int num) {
        int[] base = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] s = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        // 枚举每一位
        for (int i = base.length - 1; i >= 0; i--) {
            while (num >= base[i]) {
                sb.append(s[i]);
                num -= base[i];
            }
        }
        // 压缩,寻找连续的I,X,C
        return sb.toString();
    }
}
