package leetcode.leastInterval;


/**
 * @author itrover
 * 621. 任务调度器 https://leetcode-cn.com/problems/task-scheduler/
 * 桶思想
 */
class Solution02 {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            int index = task - 'A';
            cnt[index]++;
        }
        int maxTasks = 0;
        for (int num : cnt) {
            maxTasks = Math.max(num, maxTasks);
        }
        int maxNum = 0;
        for (int num: cnt) {
            if (maxTasks == num) {
                maxNum++;
            }
        }
        return Math.max(tasks.length, (maxTasks - 1) * (n + 1) + maxNum);
    }
}
