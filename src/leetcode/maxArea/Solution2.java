package leetcode.maxArea;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/6/17 12:31
 */

class Solution2 {
    public int maxArea(int[] height) {
        // 双指针
        // 两头向中间移动，height小的向大的一方移动
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, height[left] * (right - left));
                left ++ ;
            }else {
                res = Math.max(res, height[right] * (right - left));
                right --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1, 1};
        System.out.println(solution.maxArea(height));
    }
}