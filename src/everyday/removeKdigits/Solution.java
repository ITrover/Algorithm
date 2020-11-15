package everyday.removeKdigits;

/**
 * @author itrover
 * 402. 移掉K位数字 https://leetcode-cn.com/problems/remove-k-digits/
 * 思路：通过最多删除k位，使得每个高位能最小
 * 时间复杂度o(n*k)
 * 空间复杂度o(1)
 * todo:优化
 */
class Solution {
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
                int minus = 0;
                int l = i + 1;
                char max = arr[i];
                int t = i;
                // 去找后面比arr[i]更小的值和位置
                while (minus < k && l < arr.length) {
                    if (max > arr[l]) {
                        max = arr[l];
                        t = l;
                    }
                    l++;
                    minus++;
                }
                res[j] = arr[t];
                k -= (t - i);
                i = t;
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
}
