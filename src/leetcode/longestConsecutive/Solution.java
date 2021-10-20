package leetcode.longestConsecutive;


import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列 https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @author itrover
 * 哈希表
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            // num - 1不存在那么就以num为起点，搜索以num为最小值的连续序列
            // 如果num - 1存在，说明num可以与比他小的构成连续的序列，那么这个序列的搜索就交给比他小的数作为起点搜索，最后长度才最长
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
