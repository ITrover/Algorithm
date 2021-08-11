package leetcode.SortedStack;

import java.util.Stack;

/**
 * @author itrover
 * 面试题 03.05. 栈排序 https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 */
class SortedStack2 {

    /**
     * 栈底->栈顶降序
     */
    Stack<Integer> minStack;
    /**
     * 栈底->栈顶升序
     */
    Stack<Integer> maxStack;

    public SortedStack2() {
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int val) {
        while (!maxStack.isEmpty() && maxStack.peek() > val) {
            minStack.push(maxStack.pop());
        }
        while (!minStack.isEmpty() && minStack.peek() < val) {
            // maxStack，栈底->栈顶升序，栈顶最大，且小于minStack的栈顶
            maxStack.push(minStack.pop());
        }
        // 栈顶 > val， 栈底->栈顶降序，栈顶最小
        minStack.push(val);
    }

    public void pop() {
        // maxStack中的元素均小于minStack中的元素，且maxStack栈底的元素最小
        while (!maxStack.isEmpty()) {
            minStack.push(maxStack.pop());
        }
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int peek() {
        while (!maxStack.isEmpty()) {
            minStack.push(maxStack.pop());
        }
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return minStack.isEmpty() && maxStack.isEmpty();
    }
}
