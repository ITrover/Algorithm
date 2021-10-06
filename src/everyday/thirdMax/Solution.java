package everyday.thirdMax;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author itrover
 * 414. 第三大的数 https://leetcode-cn.com/problems/third-maximum-number/
 * 有序集合
 */
class Solution {
    public int thirdMax(int[] nums) {
        SortedSet<Integer> set = new TreeSet<Integer>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }
}
