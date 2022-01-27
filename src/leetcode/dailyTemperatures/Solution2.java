package leetcode.dailyTemperatures;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author itrover
 * 739. 每日温度 https://leetcode-cn.com/problems/daily-temperatures/
 * 暴力
 */
class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            // 倒着遍历，保证next中记录的值都比当前的值大
            int index = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t < 101; t++) {
                // 寻找比当前温度大且距离i最近的位置
                if (next[t] < index) {
                    index = next[t];
                }
            }
            if (index < Integer.MAX_VALUE) {
                res[i] = index - i;
            }
            next[temperatures[i]] = i;
        }
        return res;
    }
}
