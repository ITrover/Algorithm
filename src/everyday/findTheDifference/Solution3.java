package everyday.findTheDifference;

/**
 * @author itrover
 * 389. 找不同 https://leetcode-cn.com/problems/find-the-difference/
 * 计数 相加，相减后的差值就是插入的值
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution3 {
    public char findTheDifference(String s, String t) {
        int ts = 0;
        int tt = 0;
        ts = count(s);
        tt = count(t);
        return (char) (tt - ts);
    }

    private int count(String s) {
        int ts = 0;
        for (int i = 0; i < s.length(); i++) {
            ts += s.charAt(i);
        }
        return ts;
    }
}
