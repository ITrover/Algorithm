package everyday.intersection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author itrover
 * 349. 两个数组的交集 https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * hash表
 * 时间复杂度o(n + m)
 * 空间复杂度o(n + m)
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            arr[i] = re;
            i++;
        }
        return arr;
    }
}
