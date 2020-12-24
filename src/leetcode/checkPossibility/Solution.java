package leetcode.checkPossibility;

/**
 * @author itrover
 * 665. 非递减数列 https://leetcode-cn.com/problems/non-decreasing-array/
 * 分情况讨论
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1 && cnt < 2; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i == 0) {
                    // 头部的情况
                    nums[i] = nums[i + 1];
                } else if (i == nums.length - 2) {
                    // 尾部的情况
                    nums[i + 1] = nums[i];
                } else {
                    // 两种情况，要么修改当前元素，要么修改后面个元素
                    // 1. 当前元素过大
                    // 2. 下一个元素太小
                    // TODO: 2020/12/24 可以写得更加简洁，只需和前前一个对比，如果大，则是后面个太小，否则是当前太大
                    // 1
                    if (nums[i - 1] <= nums[i + 1]) {
                        nums[i] = nums[i + 1];
                        cnt++;
                        continue;
                    }
                    // 2
                    if (i + 2 < nums.length && nums[i] <= nums[i + 2]) {
                        nums[i + 1] = nums[i];
                        cnt++;
                        continue;
                    }
                    // 必不可能的情况
                    return false;
                }
                cnt++;
            }
        }
        return cnt <= 1;
    }
}
