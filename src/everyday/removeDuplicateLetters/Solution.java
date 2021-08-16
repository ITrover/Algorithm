package everyday.removeDuplicateLetters;

/**
 * @author itrover
 * 316. 去除重复字母 https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 贪心 + 单调栈
 * 出现一个未出现过的字符将其与单调栈中的字符比较，
 * 如果当前字符比单调栈顶中的字符的小，并且单调栈顶的字符在后续还有，则将其从单调栈中删除，并标记该字符未访问（表示后面如果还出现这个字符，可以将其放入单调栈中）
 * 循环以上过程
 * 保留当前字符到单调栈中并标记该字符访问过，将该字符出现的次数-1
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
