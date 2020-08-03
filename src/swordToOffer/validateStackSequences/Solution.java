package swordToOffer.validateStackSequences;

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 用弹出顺序来压栈
        Stack<Integer> stackData = new Stack<>();
        int pNextPush = 0;
        int pNextPop = 0;
        while (pNextPop < popped.length) {
            // 压栈条件
            if (stackData.empty() || stackData.peek() != popped[pNextPop]) {
                stackData.push(pushed[pNextPush++]);
            }
            // 弹出条件
            if (stackData.peek() == popped[pNextPop]){
                pNextPop++;
                stackData.pop();
            }
            // 错误条件
            if (pNextPush == pushed.length && !stackData.isEmpty() && stackData.peek() != popped[pNextPop]){
                return false;
            }
        }
        return true;
    }
}
