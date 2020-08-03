package swordToOffer.validateStackSequences;

import java.util.Stack;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/12 18:37
 */
class Solution3 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            // num 入栈
            stack.push(num);
            // 循环判断与出栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        // 没有弹出完毕，说明失败
        return stack.isEmpty();
    }
}

