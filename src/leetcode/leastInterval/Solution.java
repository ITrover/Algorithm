package leetcode.leastInterval;

import java.util.Arrays;

/**
 * @author itrover
 * 621. 任务调度器 https://leetcode-cn.com/problems/task-scheduler/
 * 贪心
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 尽量让任务多的先执行
        // 尽量让任务轮流执行
        Integer[] cnt = new Integer[26];
        Arrays.fill(cnt, 0);
        int total = 0;
        int res = 0;
        for (char task : tasks) {
            int index = task - 'A';
            cnt[index]++;
            total++;
        }
        while (total > 0) {
            // 排序由大到小，贪心
            Arrays.sort(cnt, (a, b) -> b - a);
            // 遍历一个周期
            int j = 0;
            int i = 0;
            for (; i <= n; i++) {
                if (total <= 0) {
                    return res;
                }
                // 无法再挑出任务执行了
                if (j >= cnt.length || cnt[j] <= 0) {
                    break;
                }
                if (cnt[j] > 0) {
                    cnt[j]--;
                    j++;
                    total--;
                }
                res++;
            }
            // 剩下的时间空转
            res += n - i + 1;
        }
        return res;
    }
}
