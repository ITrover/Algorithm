package everyday.monotoneIncreasingDigits;

/**
 * @author itrover
 * 738. 单调递增的数字 https://leetcode-cn.com/problems/monotone-increasing-digits/
 * 如果后面小于前面，那么后面全部变为9，同时前面-1
 */
class Solution2 {
    public int monotoneIncreasingDigits(int N) {
        int res = 0;
        // 倍数
        int base = 1;
        while (N > 0) {
            // 低位
            int num = N % 10;
            N /= 10;
            // 高位
            int high = N % 10;
            if (high > num) {
                // 高位大于低位，将低位全部置为9，高位数字-1
                res = base*10 - 1;
                N -= 1;
            }else  {
                // 满足递增，则相加保留
                res = num * base + res;
            }
            base *= 10;
        }
        return res;
    }
}
