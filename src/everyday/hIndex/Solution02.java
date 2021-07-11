package everyday.hIndex;

import java.util.Arrays;

/**
 * @author itrover
 * 274. H 指数 https://leetcode-cn.com/problems/h-index/
 * 计数排序
 */
class Solution02 {
    public int hIndex(int[] citations) {
        int length = citations.length;
        // i位置的值表示，引用次数为i的论文数量
        int[] counter = new int[length + 1];
        for (int citation : citations) {
            if (citation > length) {
                // 引用次数大于了数组的长度
                counter[length]++;
            } else {
                // 引用次数对应的论文数量+1
                counter[citation]++;
            }
        }
        int tol = 0;
        for (int i = counter.length - 1; i >= 0; i--) {
            tol += counter[i];
            // 如果引用次数大于i的论文数量大于了当前的引用次数i，即为h
            if (tol >= i) {
                return i;
            }
        }
        return 0;
    }
}
