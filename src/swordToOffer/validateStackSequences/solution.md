## 解题思路

### 模拟压入压出过程
### 代码
```java
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stackData = new Stack<>();
        int pNextPush = 0;
        int pNextPop = 0;
        // 要把所有元素都弹出才是正确的
        while (pNextPop < popped.length) {
            // 如果栈为空，或者栈顶元素不等于弹出元素，则一直压栈
            // 如果所有都压完了，也退出
            while (stackData.empty() || stackData.peek() != popped[pNextPop]) {
                if (pNextPush == pushed.length) {
                    // 实际上此处就能断定失败
                    // 因为把所有的元素的压完了，栈顶元素还是和待压出的元素不等
                    return false;
                }
                stackData.push(pushed[pNextPush++]);
            }
            stackData.pop();
            pNextPop++;
        }
        // 所有元素都压入并弹出，说明可行
        return true;
    }
```
