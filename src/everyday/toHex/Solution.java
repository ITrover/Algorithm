package everyday.toHex;

/**
 * @author itrover
 * 405. 数字转换为十六进制数 https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * 位运算
 */
class Solution {
    public String toHex(int num) {
        StringBuilder res = new StringBuilder();
        int i = 31;
        while (i > 0) {
            int a = 0;
            int c = 8;
            for (int j = 0; j < 4; j++) {
                a += ((num >> i) & 1) * c;
                c >>= 1;
                i--;
            }
            if (res.length() > 0 || a > 0) {
                res.append(numToHex(a));
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    char numToHex(int a) {
        return (char) (a <= 9 ? '0' + a : ('a' + (a - 10)));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toHex(9));
    }
}
