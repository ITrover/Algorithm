package swordToOffer.minStack;

import java.util.Stack;

/**
 * @author itrover
 * 剑指 Offer 30. 包含min函数的栈 https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
class MinStack {

    public Stack<Integer> data;
    public Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.size() == 0 || x < min.peek()){
            min.push(x);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();

    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

}
