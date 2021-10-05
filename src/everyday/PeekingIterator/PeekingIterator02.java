package everyday.PeekingIterator;

import java.util.Iterator;

/**
 * @author itrover
 * 284. 顶端迭代器 https://leetcode-cn.com/problems/peeking-iterator/submissions/
 */
class PeekingIterator02 implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer next;

    public PeekingIterator02(Iterator<Integer> iterator) {
        this.iterator = iterator;
        next = iterator.hasNext() ? iterator.next() : null;
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer res = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
