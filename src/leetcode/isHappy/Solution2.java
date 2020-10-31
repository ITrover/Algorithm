package leetcode.isHappy;

import java.util.HashSet;

/**
 * @author itrover
 * 202. 快乐数 https://leetcode-cn.com/problems/happy-number/
 * 使用hash表
 */
class Solution2 {

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
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            n = bitSquareSum(n);
            // 出现循环
            if (set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
    }
}
