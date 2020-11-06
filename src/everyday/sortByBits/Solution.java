package everyday.sortByBits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * @author itrover
 * 1356. 根据数字二进制下 1 的数目排序 https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 * 时间复杂度o(nlog(n))
 * 空间复杂度o(n)
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(arr).forEach(list::add);
        list.sort((a, b) -> {
            int aBit = countBit(a);
            int bBit = countBit(b);
            return aBit == bBit ? a - b : aBit - bBit;
        });
        int[] res = new int[arr.length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    int countBit(int num) {
        int res = 0;
        while (num != 0) {
            res += num & 1;
            num = num >> 1;
        }
        return res;
    }
}
