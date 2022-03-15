package everyday.countMaxOrSubsets;

/**
 * @author itrover
 * 回溯
 */
class Solution02 {

    int max;
    int res;

    public int countMaxOrSubsets(int[] nums) {
        recur(nums, 0, 0);
        return res;
    }

    private void recur(int[] nums, int index, int t) {
        if (nums.length  == index) {
            if (t > max) {
                max = t;
                res = 1;
            } else if (t == max) {
                res++;
            }
            return;
        }
        // 可以要可以不要
        recur(nums, index + 1, t | nums[index]);
        recur(nums, index + 1, t);
    }

}
