package leetcode.SortedStack;

import java.util.Stack;

/**
 * @author itrover
 * 面试题 03.05. 栈排序 https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 */
class SortedStack {

    Stack<Integer> minStack;
    Stack<Integer> tmpStack;

    public SortedStack() {
        minStack = new Stack<>();
        tmpStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || minStack.peek() > val) {
            minStack.push(val);
        } else {
            // 翻转数据
            while (!minStack.isEmpty() && minStack.peek() < val) {
                tmpStack.push(minStack.pop());
            }
            minStack.push(val);
            while (!tmpStack.isEmpty()) {
                minStack.push(tmpStack.pop());
            }
        }
    }

    public void pop() {
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int peek() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return minStack.isEmpty();
    }
}
