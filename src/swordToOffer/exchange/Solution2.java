package swordToOffer.exchange;

/**
 * 用两个 临时数组
 * 最后合并
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 *
 * 改进
 *  一个临时数组
 *  定义两个指针，一个前，一个后，奇数放前面，偶数放后面
 */
class Solution2 {
    public int[] exchange(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int l = 0, r = 0;
        //把奇偶分开放
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                left[l] = nums[i];
                l ++;
            }else{
                right[r] = nums[i];
                r ++;
            }
        }
        // 合并
        // 把偶数移到奇数后面
        for (int i = 0; i < r; i++) {
            left[l] = right[i];
            l++;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.exchange(new int[]{1, 2, 3, 4});
    }
}
