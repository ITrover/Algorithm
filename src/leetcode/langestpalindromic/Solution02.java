package leetcode.langestpalindromic;//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

/**
 * @author itrover
 * 5. 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 * manacher算法
 * 利用已经获得的回文串的信息（思想类似与kmp）
 */
class Solution02 {
    public String longestPalindrome(String s) {
        int start = 0, end = -1;
        // 初始化，使奇偶回文一样处理
        StringBuilder tmp = new StringBuilder();
        tmp.append("#");
        int n = s.length();
        for (int i = 0; i < n; i++) {
            tmp.append(s.charAt(i));
            tmp.append("#");
        }
        int[] arr = new int[tmp.length()];
        // 当前最大臂长的位置
        int maxArcIndex = -1;
        // 最长臂长能够探测到的最右距离
        int right = -1;
        s = tmp.toString();
        for (int i = 0; i < s.length(); i++) {
            int curLen;
            if (right >= i) {
                // 获的i以maxArcIndex为中心的对称点
                int sym = 2 * maxArcIndex - i;
                // 利用之前获得的数据的到最小臂长，[2maxArcIndex - right, right][maxArcIndex,right]的字符串是对称的
                // arr[sym]为对称端点的臂长，right-i为i到以maxArcIndex为中心的回文串最右端的距离
                // 有可能sym - arr[sym]的超过了以maxArcIndex为中心的回文串的左边界
                int minArc = Math.min(arr[sym], right - i);
                curLen = expand(s, i - minArc, i + minArc);
            } else {
                // 获得臂长
                curLen = expand(s, i, i);
            }
            arr[i] = curLen;
            if (i + arr[i] > right) {
                maxArcIndex = i;
                right = i + arr[i];
            }

            // 更新结果
            if (2 * arr[i] + 1 > end - start) {
                start = i - arr[i];
                end = i + arr[i];
            }
        }
        StringBuilder res = new StringBuilder();
        while (start <= end) {
            if (s.charAt(start) != '#') {
                res.append(s.charAt(start));
            }
            start++;
        }
        return res.toString();
    }

    private int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return (j - i - 2) / 2;
    }
}
