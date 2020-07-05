package sort;

/**
 * 二分插入排序
 *
 * @param <T>
 */
public class BinSort<T extends Comparable> {
    public void insertSort(T[] t) {
        T tmp = null;
        int left, mid, right;
        for (int i = 1; i < t.length; i++) {
            //保留待插入元素
            tmp = t[i];
            left = 0;
            right = i - 1;
            while (left <= right) {
                mid = (left + right) / 2;
                if (tmp.compareTo(t[mid]) <= 0) {
                    //比中间的小,应该在mid前插入
                    right = mid - 1;
                } else {
                    //比中间的大，应该在mid后插入
                    left = mid + 1;
                }
            }
            //当left == right 说明应该在此处插入。
            //将插入位置及后的元素都后移
            for (int j = i - 1; j >= left; j--) {
                t[j + 1] = t[j];
            }
            t[left] = tmp;
        }
    }
}
