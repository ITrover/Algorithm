package everyday.hIndex;

import java.util.Arrays;

/**
 * @author itrover
 * 274. H 指数 https://leetcode-cn.com/problems/h-index/
 * 排序、对题目的理解
 */
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            // 当前这篇的引用次数小于等于h，可以退出了，已经找到了最大的h
            // 为什么是小于等于呢？因为在相等的情况下，如果不退出，h的值会+1，当前的值就不符合要求了
            if (citations[i] <= h) {
                break;
            }
            // 引用大于h的论文又多了一篇
            h++;
        }
        return h;
    }
}
