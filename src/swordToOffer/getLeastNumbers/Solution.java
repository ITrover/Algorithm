package swordToOffer.getLeastNumbers;

/**
 * 由[剑指 Offer 39. 数组中出现次数超过一半的数字]改进
 *
 * 利用快速排序的特点
 * 时间复杂度 o(n) < o < o(nlog(n))
 * 空间复杂度 o(1)
 */
class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] res = new int[k];
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(arr, start, end);
            } else {
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public int partition(int[] nums, int start, int end) {
        // 中轴
        int tmp = nums[start];
        while (start < end) {
            // 右边开始找，一直找到小于tmp的位置
            while (start < end && nums[end] > tmp) {
                end--;
            }
            // 赋给中轴位置更小的值
            nums[start] = nums[end];
            // 一直找直到找到左边大于tmp的位置
            while (start < end && nums[start] <= tmp) {
                start++;
            }
            // 左边出现了比tmp大的数
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        // 返回的是中轴的位置
        return start;
    }
}
