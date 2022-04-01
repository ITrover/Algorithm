package leetcode.canReorderDoubled;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 954. 二倍数对数组 https://leetcode-cn.com/problems/array-of-doubled-pairs/
 * 回溯 (超时)
 */
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if (arr.length == 0) {
            return true;
        }
        // 哈希表，全部成对就ok
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int mLen = arr.length / 2;
        return recur(mLen, 0, arr, map);
    }

    private boolean recur(int mLen, int index, int[] arr, Map<Integer, Integer> map) {
        if (mLen <= 0) {
            return true;
        }
        if (index == arr.length) {
            return false;
        }
        if (map.getOrDefault(arr[index], 0) > 0) {
            // 如果num*2和num/2都有，那么就有选择了，到底是num*2还是num/2
            map.put(arr[index], map.get(arr[index]) - 1);
            int dNum = arr[index] * 2;
            if (map.getOrDefault(dNum, 0) > 0) {
                // 将2*num的数量 - 1
                map.put(dNum, map.get(dNum) - 1);
                if (recur(mLen - 1, index + 1, arr, map)) {
                    return true;
                }
                // 还原
                map.put(dNum, map.get(dNum) + 1);
            }
            dNum = arr[index] / 2;
            if (arr[index] % 2 == 0 && map.getOrDefault(dNum, 0) > 0) {
                map.put(dNum, map.get(dNum) - 1);
                if (recur(mLen - 1, index + 1, arr, map)) {
                    return true;
                }
                map.put(dNum, map.get(dNum) + 1);
            }
            map.put(arr[index], map.get(arr[index]) + 1);
        } else {
            // 当前数字已用完
            return recur(mLen, index + 1, arr, map);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canReorderDoubled(new int[]{1, 2, 4, 8}));
    }
}
