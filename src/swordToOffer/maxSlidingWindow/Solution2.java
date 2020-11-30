package swordToOffer.maxSlidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author itrover
 * 剑指 Offer 59 - I. 滑动窗口的最大值 https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * 使用双端队列
 * 时间复杂度 o(n)
 * 空间复杂度 o(k)
 */
class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            // 构建一个单调队列，由大到小
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        // 取出窗口中最大的一个值
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            // 删除前一个窗口对应的第一个值
            if(deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            // 加入一个新的元素，同时保持队列的单调
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
