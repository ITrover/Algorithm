package leetcode.findDifferentBinaryString;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 1980. 找出不同的二进制字符串 https://leetcode-cn.com/problems/find-unique-binary-string/
 * 哈希表
 */
class Solution02 {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }
        for (int i = 0; i < (1 << nums[0].length()); i++) {
            if (!set.contains(i)) {
                StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
                while (s.length() < nums[0].length()) {
                    s.insert(0, "0");
                }
                return s.toString();
            }
        }
        return null;
    }
}
