package everyday.removeDuplicates2;

/**
 * @author itrover
 * 80. 删除有序数组中的重复项 II https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * 三指针
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            // 找到第一个不相等的地方
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (start == i) {
                // 这个时候，start偏移就行
                // 重复多个(大于2)
                if (i + 2 < j) {
                    start += 2;
                } else {
                    start = j;
                }
            } else {
                // start被修改，无论如何都要搬移了
                int mov = Math.min(2, j - i);
                for (int k = 0; k < mov; k++) {
                    nums[start++] = nums[i + k];
                }
            }
            i = j;
        }
        return start;
    }
}
