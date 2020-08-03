package swordToOffer.exchange;

/**
 * 思路
 *     定义两个指针，一前一后
 *     当前指针指的是偶数时，找到后指针指到奇数的位置
 *     然后替换
 * 题型：
 * 双指针
 * 时间复杂度：o(n)
 * 改进
 *  先分别通过循环，找到左边的奇数和右边的偶数
 *  再替换
 */
class Solution {
    public int[] exchange(int[] nums) {
        int pre = 0;
        int last = nums.length - 1;
        while (pre < last) {
            if (nums[pre] % 2 == 0) {
                // 如果pre是偶数，则可以和后面的交换
                // 防止越界
                while (nums[last] % 2 == 0 && pre < last) {
                    last--;
                }
                // 交换
                // 考虑越界的情况
                if (pre < last) {
                    int temp = nums[last];
                    nums[last] = nums[pre];
                    nums[pre] = temp;
                    last--;
                }
            }
            pre++;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.exchange(new int[]{1, 2, 3, 4});
    }
}
