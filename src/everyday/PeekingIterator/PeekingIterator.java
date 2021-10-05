package everyday.PeekingIterator;

import java.util.Iterator;

/**
 * @author itrover
 * 284. 顶端迭代器 https://leetcode-cn.com/problems/peeking-iterator/submissions/
 */
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (next == null) {
            next = iterator.next();
        }
        return next;
    }

    @Override
    public Integer next() {
        Integer res;
        // 返回由于peek临时保存的元素
        if (next != null) {
            res = next;
            next = null;
            return res;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return next != null || iterator.hasNext();
    }
}
