package leetcode.chalkReplacer;

/**
 * @author itrover
 * 1894. 找到需要补充粉笔的学生编号 https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 * 两次循环
 * 是时间复杂度o(n)
 */
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                return i;
            }
        }
        return chalkReplacer(chalk, k % sum);
    }
}
