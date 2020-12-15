package everyday.monotoneIncreasingDigits;

/**
 * @author itrover
 * 738. 单调递增的数字 https://leetcode-cn.com/problems/monotone-increasing-digits/
 * 贪心算法，即找到前面最长的递增序列
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        // 找到递增的部分如12301的123
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            // 将连续递增的低位 - 1
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            // 后面全部为0
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
