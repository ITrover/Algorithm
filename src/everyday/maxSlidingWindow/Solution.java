package everyday.maxSlidingWindow;

import java.util.ArrayDeque;

/**
 * @author itrover
 * 239. 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/
 * 和剑指offer的滑动窗口那题一样
 * 双端队列
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return new int[]{-1};
        }
        int[] res = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        // 单调栈，从大到小
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.getFirst();
        if (deque.getFirst() == nums[0]){
            deque.removeFirst();
        }
        for (int i = k; i < nums.length; i++) {
            // 添加第i位的元素
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.getFirst();
            // 删除下一个滑动窗口外的元素
            if (nums[i - k + 1] == deque.getFirst()){
                deque.removeFirst();
            }
        }
        return res;
    }
}
