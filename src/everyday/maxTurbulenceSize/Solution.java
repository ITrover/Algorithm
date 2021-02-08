package everyday.maxTurbulenceSize;

/**
 * @author itrover
 * 978. 最长湍流子数组 https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * 类似暴力
 */
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int res = 1;
        boolean sign;
        int cnt01 = 1;
        int cnt02 = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            // 判断是否满足喘流
            if ((i & 1) == 1) {
                sign = arr[i] > arr[i + 1];
            } else {
                sign = arr[i] < arr[i + 1];
            }
            // 相等的情况
            if (arr[i] == arr[i + 1]) {
                cnt01 = 1;
                cnt02 = 1;
                continue;
            }
            if (sign) {
                cnt02 = 1;
                cnt01++;
            } else {
                cnt02++;
                cnt01 = 1;
            }
            res = Math.max(cnt01, res);
            res = Math.max(cnt02, res);
        }
        return res;
    }
}
