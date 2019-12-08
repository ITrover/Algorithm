package sort;

/**
 * 插入排序
 * @param <T>
 */
public class InsertSort<T extends Comparable> {
    public void insertSort(T[] t) {
        for (int i = 1; i < t.length; i++) {
            //第i个位置的元素即为待插入的元素
            //通过与前面i-1个比较，如果比之前的小就依次插入
            T tmp = t[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (tmp.compareTo(t[j]) <= 0) {
                    //依次后移
                    t[j + 1] = t[j];
                } else {
                    //此时tmp比第j个小，那么tmp应该放在j的后面。
                    break;
                }
            }
            t[j + 1] = tmp;
        }
    }

}
