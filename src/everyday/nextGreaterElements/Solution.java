package everyday.nextGreaterElements;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author itrover
 * 503. 下一个更大元素 II https://leetcode-cn.com/problems/next-greater-element-ii/
 * 单调栈 循环数组
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}
