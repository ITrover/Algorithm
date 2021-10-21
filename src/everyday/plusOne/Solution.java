package everyday.plusOne;

/**
 * @author itrover
 * 66. 加一 https://leetcode-cn.com/problems/plus-one/
 * 数组
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (c + digits[i] == 10) {
                digits[i] = 0;
            } else {
                digits[i] += c;
                c = 0;
                break;
            }
        }
        int[] res = digits;
        // 还有进位
        if (c == 1) {
            res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
        }
        return res;
    }
}
