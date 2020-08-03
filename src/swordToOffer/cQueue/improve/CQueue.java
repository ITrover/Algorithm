package swordToOffer.cQueue.improve;

import java.util.Stack;


/**
 * 用两个栈实现队列
 *
 */
class CQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    /**
     * s2负责出，s1负责进
     * 当s2不为空时，直接返回s2的顶元素
     * 当s2为空时，把s1的元素全部push进s2，返回s2的顶元素
     * @return
     */
    public int deleteHead() {
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }
}
