package swordToOffer.medianFinder;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 查找复杂度o(1)
 * 插入复杂度o(log(n))
 */
class MedianFinder {

    Queue<Integer> A, B;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        // 小顶堆，保存较大的一半
        A = new PriorityQueue<>();
        // 大顶堆，保存较小的一半
        B = new PriorityQueue<>((x, y) -> (y - x));
    }


    public void addNum(int num) {
        // 由于奇数时，将A中最小的元素放到B中
        // 偶数时，将B中最大的元素放到A中
        // 保证了A中元素全部都大于B。
        if (A.size() != B.size()){
            // 奇数时，将num插入A中，并将A中最小的数，放到B中
            A.add(num);
            B.add(A.poll());
        }else{
            // 偶数时，将num放入B中，并将B中最大的数，放到A中。
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        // 奇数时，小顶堆堆顶元素就是中位数
        // 偶数时，两个堆堆顶顶元素的平均数就是中位数
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
