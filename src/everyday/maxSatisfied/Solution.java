package everyday.maxSatisfied;

/**
 * @author itrover
 * 1052. 爱生气的书店老板 https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * 滑动区间
 * 能够增加的客户满意数是不满意的客户数
 */
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        int unSatisfied = 0;
        int left = 0;
        int right = 0;
        while (right < customers.length && right < X) {
            if (grumpy[right] == 1) {
                unSatisfied += customers[right];
            } else {
                res += customers[right];
            }
            right++;
        }
        int maxUnSatisfied = unSatisfied;
        // 滑动区间
        while (right < customers.length) {
            if (grumpy[right] == 1) {
                unSatisfied += customers[right];
            } else {
                res += customers[right];
            }
            if (grumpy[left] == 1) {
                unSatisfied -= customers[left];
            }
            maxUnSatisfied = Math.max(unSatisfied, maxUnSatisfied);
            right++;
            left++;
        }
        return res + maxUnSatisfied;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
    }
}
