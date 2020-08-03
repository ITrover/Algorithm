package swordToOffer.cQueue;

import java.util.Stack;


/**
 * 用两个栈实现队列
 * 一个栈用来保存所有push的数据
 * 再deleteHead的时候，把前面的元素放在另一个元素，然后再倒转过来
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

    public int deleteHead() {
        if (s1.isEmpty()) {
            return -1;
        } else {
            while (!s1.isEmpty()){
                Integer integer = s1.pop();
                s2.push(integer);
            }
            int result = s2.pop();
            while (!s2.isEmpty()){
                Integer integer = s2.pop();
                s1.push(integer);
            }
            return result;
        }
    }
}
