package everyday.findMinFibonacciNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 1414. 和为 K 的最少斐波那契数字数目 https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 * 贪心
 */
class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> f = new ArrayList<Integer>();
        f.add(1);
        int a = 1, b = 1;
        while (a + b <= k) {
            int c = a + b;
            f.add(c);
            a = b;
            b = c;
        }
        int ans = 0;
        // 需证明
        for (int i = f.size() - 1; i >= 0 && k > 0; i--) {
            int num = f.get(i);
            if (k >= num) {
                k -= num;
                ans++;
            }
        }
        return ans;
    }
}
