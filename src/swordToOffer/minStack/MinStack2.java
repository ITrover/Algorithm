package swordToOffer.minStack;

import java.util.Stack;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/12/4 21:12
 */
class MinStack2 {

    Stack<Integer> data;
    Stack<Integer> min;

    public MinStack2() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(min.isEmpty() || min.peek() >= x){
            min.push(x);
        }
    }

    public void pop() {
        // 一定不能用 == ，放回的是对象
        if(!min.isEmpty() && min.peek().equals(data.pop()) ){
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
