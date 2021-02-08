package everyday.maxTurbulenceSize;
/**
 * @author itrover
 * 978. 最长湍流子数组 https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * 双指针
 */
class Solution2 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ret = 1;
        int left = 0, right = 0;

        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                // 将题目的喘流条件翻译为以下两个条件
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    // 条件1，right - 1 < right > right + 1
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    // 条件2，right - 1 > right < right + 1
                    right++;
                } else {
                    left = right;
                }
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}
