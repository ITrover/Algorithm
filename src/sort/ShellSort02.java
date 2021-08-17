package sort;

import java.util.Arrays;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2021/8/16 22:51
 * 希尔排序
 */
public class ShellSort02<T extends Comparable> {

    private void shellSort(T[] t) {
        int len = t.length;
        for (int step = (len / 2); step > 0; step /= 2) {
            // 对step后面所有元素(第1个子序列的第二个元素)都进行步数为step的插入排序，即对step个序列进行插入排序
            for (int i = step; i < len; i++) {
                if (t[i].compareTo(t[i - step]) < 0) {
                    // 如果当前的小于前面的才需要往前插入
                    T tmp = t[i];
                    int j;
                    for (j = i - step; j >= 0 && tmp.compareTo(t[j]) < 0; j -= step) {
                        // 当前更小，则往前搬移
                        t[j + step] = t[j];
                    }
                    t[j + step] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        ShellSort02<Integer> sort = new ShellSort02<>();
        Integer[] integers = {1, 3, 2, 7, 9, 20, 1, 0, 4};
        sort.shellSort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
