package sort;

/**
 * 堆排序
 * 基本思路
 * 1.将待排序集合，用堆表示，将最大的数放在堆顶。
 * 2.将堆顶元素和堆尾元素交换，同时堆的长度-1
 * 重复1 2 操作直到堆的长度变为1.
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable> {
    public void sort(T[] t) {
        int heaplen = t.length;
        for (int i = t.length - 1; i > 0; i--) {
            buildHeap(t, heaplen);
            swap(t, 0, i);
            heaplen--;
        }
    }

    /**
     * 调整堆，让i位置的节点的子节点小于自身。
     *
     * @param t   堆
     * @param i   根节点
     * @param len 对的长度
     */
    private void adjustHeap(T[] t, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        //就是一个三数比较大小，把最大的放在i所在位置
        if (left < len && t[left].compareTo(t[largest]) > 0) {
            largest = left;
        }
        if (right < len && t[right].compareTo(t[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(t, i, largest);
        }
    }

    /**
     * 经过调整，将最大的元素放在第一个位置（0）
     *
     * @param t
     * @param len logical length of t
     */
    private void buildHeap(T[] t, int len) {
        //从后面的节点开始调整。
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(t, i, len);
        }
    }

    private void swap(T[] t, int i, int largest) {
        T tmp = t[i];
        t[i] = t[largest];
        t[largest] = tmp;
    }

}
