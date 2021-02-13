package everyday.findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 448. 找到所有数组中消失的数字 https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * 技巧性，数组原地修改
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            // 找到当前元素的索引，并让其元素上的数字+n
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 如果<=n，表明在上一个循环中，没有被修改，则当前索引对应的数字不在数组中
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
