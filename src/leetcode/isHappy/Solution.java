package leetcode.isHappy;

/**
 * @author itrover
 * 202. 快乐数 https://leetcode-cn.com/problems/happy-number/
 * 快慢指针
 */
class Solution {

    int bitSquareSum(int n) {
        int res = 0;
        while (n > 0) {
            int t = n % 10;
            res += t * t;
            n /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
            // 通过快慢指针避免出现循环
        } while (slow != fast);

        return slow == 1;
    }
}
