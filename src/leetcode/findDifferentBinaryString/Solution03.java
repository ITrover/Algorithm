package leetcode.findDifferentBinaryString;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 1980. 找出不同的二进制字符串 https://leetcode-cn.com/problems/find-unique-binary-string/
 * 哈希表
 */
class Solution03 {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>(Arrays.asList(nums));
        char[] number = new char[nums[0].length()];
        Arrays.fill(number, '0');
        do {
            if (!set.contains(new String(number))) {
                return new String(number);
            }
        } while (add(number));
        return null;
    }

    private boolean add(char[] number) {
        int i = number.length - 1;
        while (i >= 0) {
            if (number[i] == '1') {
                number[i] = '0';
            } else {
                number[i] = '1';
                return true;
            }
            i--;
        }
        return false;
    }
}
