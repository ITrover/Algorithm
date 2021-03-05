package leetcode.myQueue;

import java.util.Stack;

/**
 * @author itrover
 * 232. 用栈实现队列 https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
class MyQueue {

    private Stack<Integer> a;
    private Stack<Integer> b;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        a.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        moveA2B();
        return b.pop();
    }

    private void moveA2B() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        moveA2B();
        return b.isEmpty() ? -1 : b.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        moveA2B();
        return b.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
