package swordToOffer.reversePairs;

/**
 * 利用归并排序的特点、
 * 时间复杂度nlog(n)
 */
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] copy = new int[nums.length];
        return count(nums, copy, 0, nums.length - 1);
    }

    public int count(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }

        int length = (end - start) / 2;
        // 左边返回的结果
        int left = count(nums, copy, start, start + length);
        // 右边返回的结果
        int right = count(nums, copy, start + length + 1, end);
        // 前半段最后一个数
        int i = start + length;
        // 后半段的最后一个数
        int j = end;
        // 合并的开始位置
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (nums[i] > nums[j]) {
                // 前半段的数大于后半段的数
                copy[indexCopy--] = nums[i--];
                // 这是关键
                // 逆序数由后半部分剩下的个数决定
                count += j - start - length;
            } else {
                copy[indexCopy--] = nums[j--];
            }
        }
        // 将剩下的放到数组中
        for (; i >= start; i--) {
            copy[indexCopy--] = nums[i];
        }

        for (; j >= start + length + 1; j--) {
            copy[indexCopy--] = nums[j];
        }
        System.arraycopy(copy, start, nums, start, end - start + 1);
        return left + right + count;
    }

}
