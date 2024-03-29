package everyday.clumsy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author itrover
 * 1006. 笨阶乘 https://leetcode-cn.com/problems/clumsy-factorial/
 * 使用栈
 */
class Solution3 {
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N);
        N--;
        // 用于控制乘、除、加、减
        int index = 0;
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 把栈中所有的数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
