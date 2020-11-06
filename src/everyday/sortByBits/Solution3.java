package everyday.sortByBits;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author itrover
 * 1356. 根据数字二进制下 1 的数目排序 https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 * 利用题目条件 0 <= arr[i] <= 10^4
 * 时间复杂度o(nlog(n))
 * 空间复杂度o(n)
 */
class Solution3 {
    public int[] sortByBits(int[] arr) {
        final int plus = 100_000;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = Integer.bitCount(arr[i]) * plus + arr[i];
        }
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] % plus;
        }
        return res;
    }
}
