package everyday.findTheDifference;

/**
 * @author itrover
 * 389. 找不同 https://leetcode-cn.com/problems/find-the-difference/
 * 异或:相同为0
 * 两个字符串异或后，只有插入的哪个字母会剩下
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution4 {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }
        return res;
    }
}
