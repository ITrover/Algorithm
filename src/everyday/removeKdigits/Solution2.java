package everyday.removeKdigits;

/**
 * @author itrover
 * 402. 移掉K位数字 https://leetcode-cn.com/problems/remove-k-digits/
 * 思路：通过最多删除k位，使得每个高位能最小
 * 时间复杂度o(n*k)
 * 空间复杂度o(1)
 */
class Solution2 {
    public String removeKdigits(String num, int k) {
        // 删除的位数等于数字长度
        if (num.length() == k) {
            return "0";
        }
        // 让高位尽量的小
        char[] arr = num.toCharArray();
        char[] res = new char[num.length() - k];
        int j = 0;
        for (int i = 0; i < arr.length && j < res.length; i++) {
            if (k > 0) {
                // 最小值的下标t
                int t = findMin(arr, i, k);
                // 删除[i,t)之间的数字
                k -= (t - i);
                i = t;
                res[j] = arr[t];
            } else {
                res[j] = arr[i];
            }
            j++;
        }
        j = 0;
        // 删除前导的0
        while (j < res.length && res[j] == '0') {
            j++;
        }
        return j == res.length ? "0" : new String(res, j, res.length - j);
    }

    /**
     * 找到[start,start+n]中最小的数的下标
     * @param arr
     * @param start
     * @param n
     * @return 最小值的下标
     */
    int findMin(char[] arr, int start, int n) {
        int min = arr[start];
        int res = start;
        for (int i = start + 1; i < arr.length && n > 0; i++) {
            if (min > arr[i]) {
                min = arr[i];
                res = i;
            }
            n--;
        }
        return res;
    }
}
