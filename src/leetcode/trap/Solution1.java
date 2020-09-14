package leetcode.trap;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/6/27 20:34
 * 双指针
 * 时间复杂度o(n)
 * 柱子能装多少水，由它左右最小的柱子决定
 */

public class Solution1 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while(left < right){
            if (height[left] < height[right]){
                if(height[left] > leftMax){
                    leftMax = height[left];
                }else {
                    res += leftMax - height[left];
                }
                left ++;
            }else{
                if(height[right] > rightMax){
                    rightMax = height[right];
                }else {
                    res += rightMax - height[right];
                }
                right --;
            }
        }
        return res;
    }
}
