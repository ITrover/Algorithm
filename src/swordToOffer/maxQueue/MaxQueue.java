package swordToOffer.maxQueue;

import java.util.*;

/**
 * 双端队列
 *
 * 对于队列某位置的元素，它为首元素时，队列的最大值，由后面的值决定
 *
 * 最大队列保存的是递减的元素
 */
class MaxQueue {

    Queue<Integer> queue;
    LinkedList<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        //LinkedList是双端链表
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.isEmpty() ? -1 : max.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!max.isEmpty() && max.getLast() < value) {
            max.removeLast();
        }
        max.add(value);
    }

    public int pop_front() {
        // 当max中的第一个等于当前弹出值时，删除max中的第一个
        if (!max.isEmpty() && queue.peek().equals(max.getFirst()))
        {
            max.removeFirst();
        }
        return queue.isEmpty() ? -1 : queue.poll();
    }

}
