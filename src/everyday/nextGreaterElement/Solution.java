package everyday.nextGreaterElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 496. 下一个更大元素 I https://leetcode-cn.com/problems/next-greater-element-i/
 * 哈希表
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 记录坐标
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int j = 0, nums1Length = nums1.length; j < nums1Length; j++) {
            int num = nums1[j];
            int index = map.get(num);
            for (int i = index; i < nums2.length; i++) {
                if (num < nums2[i]) {
                    res[j] = nums2[i];
                    break;
                }
            }
        }
        return res;
    }
}
