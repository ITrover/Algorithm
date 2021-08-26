package tencent.binarySearch.mySqrt;

/**
 * @author itrover
 * 二分查找
 */
class Solution {
    public int mySqrt(int x) {
        // 寻找左边界
        int left = 0, right = x;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long doubleMid = (long) mid * mid;
            if (doubleMid >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (long) left * left > x ? left - 1 : left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(
                5));
    }
}
