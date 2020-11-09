package leetcode.addDigits;

/**
 * @author itrover
 * 258. 各位相加 https://leetcode-cn.com/problems/add-digits/
 * 找规律 o(1) xyz=100*x+10*y+z=99*x+9*y+x+y+z
 */
class Solution2 {

    public int addDigits(int num) {
        if (num % 9 == 0 && num != 0) {
            num = 9;
        } else {
            num %= 9;
        }
        return num;
    }
}
