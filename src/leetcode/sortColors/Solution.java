package leetcode.sortColors;

/**
 * @author itrover
 * 75. 颜色分类 https://leetcode-cn.com/problems/sort-colors/
 * 桶排序
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        // 桶排序
        int[] cnt = new int[3];
        for (int num : nums) {
            // 每个数出现的次数
            cnt[num]++;
        }
        int k = 0;
        // 放回去
        for (int i = 0; i < cnt.length; i++) {
            int count = cnt[i];
            for (int j = 0; j < count; j++) {
                nums[k++] = i;
            }
        }
    }
}
