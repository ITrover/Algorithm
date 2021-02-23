package everyday.maxSatisfied;

/**
 * @author itrover
 * 1052. 爱生气的书店老板 https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * 滑动区间
 */
class Solution2 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        int unSatisfied = 0;
        int maxUnsatisfied = 0;
        for (int right = 0; right < customers.length; right++) {
//            if (grumpy[right] == 1) {
//                // 不开心
//                unSatisfied += customers[right];
//            } else {
//                res += customers[right];
//            }
            if (grumpy[right] == 0){
                res += customers[right];
            }
            // 使用乘法，取代判断
            unSatisfied += customers[right] * grumpy[right];
            if (right >= X) {
                int left = right - X;
                unSatisfied -= customers[left] * grumpy[left];
//                if (grumpy[left] == 1) {
//                    unSatisfied -= customers[left];
//                }
            }
            maxUnsatisfied = Math.max(unSatisfied, maxUnsatisfied);
        }
        return res + maxUnsatisfied;
    }
}
