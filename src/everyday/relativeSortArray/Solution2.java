package everyday.relativeSortArray;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.*;

/**
 * @author itrover
 * 1122. 数组的相对排序 https://leetcode-cn.com/problems/relative-sort-array/
 * 修改排序规则
 * 时间复杂度o(nlog(n)) // 排序
 * 空间复杂度o(n)
 */
class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] pos = new int[1001];
        Arrays.fill(pos, 1001);
        for (int i = 0; i < arr2.length; i++) {
            pos[arr2[i]] = i;
        }
        ArrayList<Integer> res = new ArrayList<>(arr1.length);
        for (int num : arr1) {
            res.add(num);
        }
        res.sort((a, b) -> {
            if (pos[a] != 1001 || pos[b] != 1001) {
                return pos[a] - pos[b];
            }
            return a - b;
        });
        int[] ans = new int[arr1.length];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
