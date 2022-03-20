package leetcode.countPrimes;

import java.util.ArrayList;
import java.util.List;

/**
 * 204. 计数质数 https://leetcode-cn.com/problems/count-primes/
 *
 */
class Solution {
    public int countPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            // 如果N不为质数，都可以唯一分解成有限个质数的乘积
            for (Integer integer : list) {
                if (i % integer == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                list.add(i);
            }
        }
        return list.size();
    }
}
