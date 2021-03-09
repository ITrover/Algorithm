package everyday.removeDuplicates;

/**
 * @author itrover
 * 1047. 删除字符串中的所有相邻重复项 https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 栈
 */
class Solution2 {
    public String removeDuplicates(String S) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top >= 0 && stack.charAt(top) == S.charAt(i)) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(S.charAt(i));
                top++;
            }
        }
        return stack.toString();
    }
}
