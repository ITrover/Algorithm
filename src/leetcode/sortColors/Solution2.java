package leetcode.sortColors;

/**
 * @author itrover
 * 75. 颜色分类 https://leetcode-cn.com/problems/sort-colors/
 * 单指针、技巧性
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution2 {
    public void sortColors(int[] nums) {
        int ptr = 0;
        // 把0的移动到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                swap(i,ptr,nums);
                ptr++;
            }
        }
        // 把1的移动到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                swap(i,ptr,nums);
                ptr++;
            }
        }
    }
    void swap(int a, int b, int[] nums){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

