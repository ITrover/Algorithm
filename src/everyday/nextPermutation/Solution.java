package everyday.nextPermutation;

import java.util.Arrays;

/**
 * @author itrover
 * 31. 下一个排列 https://leetcode-cn.com/problems/next-permutation/
 * ① 升序是最最小的数，降序是最大的数
 * ② 找到后面降序的部分，此时对于降序部分，它们是最大的，记为[m,n]
 * ③ 要想使下一数比当前大，只能增大降序前面的数(m-1)
 * ④ 找到降序部分中大于(m-1)的数，并交换，固定(m-1)，无论[m,n]如何排列，[m-1,n]都比之前大(高位(m-1)比之前的大)
 * ⑤ 固定(m-1),使[m,n]最小，此时的数就是第一个大于之前的数的下一个数
 * 找规律
 * 时间复杂度最差o(nlog(n)) 最优o(1) 平均log(n)
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            // nums是降序序列
            // Arrays.sort(nums);

            // 优化
            // 由于是降序变成升序，所以可以直接首尾反转
            reverse(nums, 0);
            return;
        }
        // 将后面降序改为升序
        // Arrays.sort(nums, i + 1, nums.length);

        reverse(nums,i + 1);
        int j = i + 1;
        // 找到后面升序中第一个大于nums[i]的位置，并交换
        while (j < nums.length && nums[i] >= nums[j]) {
            j++;
        }
        swap(nums, i, j);
    }

    /**
     * 反转
     * @param nums
     * @param start
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
}
