package everyday.sortByBits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author itrover
 * 1356. 根据数字二进制下 1 的数目排序 https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 * 遍历两次
 * 时间复杂度o(nlog(n))
 * 空间复杂度o(n)
 */
class Solution2 {
    public int[] sortByBits(int[] arr) {
        List[] lists = new List[32];
        for (int i = 0; i < 32; i++) {
            lists[i] = new ArrayList<Integer>();
        }
        for (int j : arr) {
            int b = countBit(j);
            lists[b].add(j);
        }
        int[] rs = new int[arr.length];
        int k = 0;
        for (List<Integer> list : lists) {
            list.sort((a,b)->{return a - b;});
            for (Integer integer : list) {
                rs[k] = integer;
                k++;
            }
        }
        return rs;
    }

    int countBit(int num) {
        int res = 0;
        while (num != 0) {
            res += num & 1;
            num = num >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(solution2.sortByBits(new int[]{1, 2, 3, 4, 5, 6, 7, 8})));
    }
}
