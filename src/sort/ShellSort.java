package sort;

import java.util.Arrays;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2021/8/16 22:51
 * 希尔排序
 */
public class ShellSort<T extends Comparable> {
    private void insertSort(T[] t, int step) {
        // 一共有step个子序列，以此对其插入排序
        for (int i = 0; i < step; i++) {
            // 插入排序
            for (int j = i + step; j < t.length; j += step) {
                // 从后往前插入
                T tmp = t[j];
                int k;
                for (k = (j - step); k >= 0; k -= step) {
                    // tmp更小，则往前插入
                    if (tmp.compareTo(t[k]) <= 0) {
                        t[k + step] = t[k];
                    } else {
                        // 此位置就是插入的位置
                        break;
                    }
                }
                t[k + step] = tmp;
            }
        }
    }

    private void shellSort(T[] t) {
        int len = t.length;
        for (int i = (len / 2); i > 0; i /= 2) {
            insertSort(t, i);
        }
    }

    public static void main(String[] args) {
        ShellSort<Integer> sort = new ShellSort<>();
        Integer[] integers = {1, 3, 2,7,9,20,1,0,4};
        sort.shellSort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
