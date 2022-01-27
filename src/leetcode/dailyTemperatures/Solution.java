package leetcode.dailyTemperatures;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author itrover
 * 739. 每日温度 https://leetcode-cn.com/problems/daily-temperatures/
 * 单调栈
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 把栈中比当前值小的弹出，并且更新答案
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
