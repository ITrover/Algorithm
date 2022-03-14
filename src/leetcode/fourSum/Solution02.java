package leetcode.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author itrover
 * 18. 四数之和 https://leetcode-cn.com/problems/4sum/
 * 双指针
 * 时间复杂度o(n^3)
 */
class Solution02 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 4) {
            return res;
        }
        long sum;
        for (int i = 0; i < n - 3; i++) {
            // 避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 都大于target
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 当前数加上最大的三个数都小于target
            if ((long)nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long)nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                long towSum = (long)nums[i] + nums[j];
                int left = j + 1, right = n - 1;
                // 双指针
                while (left < right) {
                    // long + int，int转换成long，结果为long
                    // long = int + int，两个int相加会溢出
                    sum = towSum + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

        }
        return res;
    }

}
