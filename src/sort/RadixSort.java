package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/11/26 20:45
 * 基数排序，适用于整数的排序
 * 从最低位开始，根据每一位的大小分别进行排序。
 * 即先用个位进行排序，再用十位进行排序，再用（百，千。。。）位进行排序
 */
public class RadixSort {
    public void sort(int[] data) {
        int max = Arrays.stream(data).max().getAsInt();
        int dev = 1;
        while (max != 0) {
            sort(data, dev);
            dev *= 10;
            max /= 10;
        }
    }
    /**
     * @param data
     * @param dev 除数，即选取倒数log(10,dev)哪一位进行排序
     */
    public void sort(int[] data, int dev) {
        List[] bucket = new List[10];
        for (int i = 0; i < 10; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        for (int num : data) {
            // 计算倒数log(10,dev)位对应的索引，并添加到对应的桶中
            int index = (num / (dev)) % 10;
            bucket[index].add(num);
        }
        int index = 0;
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < bucket[j].size(); k++) {
                data[index] = (int) bucket[j].get(k);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2,4,5,6,10,12,13,24,36,101,120,201,30,21,2009,2190};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}

