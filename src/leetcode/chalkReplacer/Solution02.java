package leetcode.chalkReplacer;

/**
 * @author itrover
 * 1894. 找到需要补充粉笔的学生编号 https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 * 前缀和 + 二分查找
 * 是时间复杂度o(n)
 */
class Solution02 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if (chalk[0] > k) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            chalk[i] += chalk[i - 1];
            if (chalk[i] > k) {
                return i;
            }
        }
        return binarySearch(chalk, k % chalk[n - 1]);
    }

    int binarySearch(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        // 停在第一个大于k的位置
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid] > k) {
                r = mid - 1;
            } else if (arr[mid] <= k) {
                l = mid + 1;
            }
        }
        return l;
    }
}
