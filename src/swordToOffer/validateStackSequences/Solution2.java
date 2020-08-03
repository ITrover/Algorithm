package swordToOffer.validateStackSequences;

import java.util.Stack;

class Solution2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 用弹出顺序来压栈
        Stack<Integer> stackData = new Stack<>();
        int pNextPush = 0;
        int pNextPop = 0;
        while (pNextPop < popped.length) {
            // 如果栈为空，或者栈顶元素不等于弹出元素，则一直压栈
            // 如果所有都压完了，也退出
            while (stackData.empty() || stackData.peek() != popped[pNextPop]) {
                if (pNextPush == pushed.length) {
                    // 实际上此处就能断定失败
                    // 因为把所有的元素的压完了，栈顶元素还是和待压出的元素不等
                    break;
                }
                stackData.push(pushed[pNextPush++]);
            }
            // 如果栈顶和弹出元素不相等，则失败
            if (stackData.peek() != popped[pNextPop]) {
                return false;
            }
            stackData.pop();
            pNextPop++;
        }
        return true;
    }
}
