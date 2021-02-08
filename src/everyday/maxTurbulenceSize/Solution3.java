package everyday.maxTurbulenceSize;

/**
 * @author itrover
 * 978. 最长湍流子数组 https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * 动态规划
 */
class Solution3 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int res = 1;
        int cnt01 = 1;
        int cnt02 = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                // (前面是 > 的 )+ 1
                cnt01 = cnt02 + 1;
                cnt02 = 1;
            } else if (arr[i] > arr[i + 1]) {
                cnt02 = cnt01 + 1;
                cnt01 = 1;
            } else {
                cnt01 = 1;
                cnt02 = 1;
            }
            res = Math.max(cnt01, res);
            res = Math.max(cnt02, res);
        }
        return res;
    }
}
