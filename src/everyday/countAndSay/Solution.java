package everyday.countAndSay;

/**
 * @author itrover
 * 38. 外观数列 https://leetcode-cn.com/problems/count-and-say/submissions/
 * 迭代
 */
class Solution {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder();
        if (n <= 0) {
            return res.toString();
        }
        res.append("1");
        for (int i = 0; i < n - 1; i++) {
            res = countAndSay(res);
        }
        return res.toString();
    }

    public StringBuilder countAndSay(StringBuilder s) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            res.append((j - i));
            res.append(s.charAt(i));
            i = j;
        }
        return res;
    }

}
