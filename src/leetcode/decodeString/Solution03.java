package leetcode.decodeString;

/**
 * @author itrover
 * 394. 字符串解码 https://leetcode-cn.com/problems/decode-string/
 * 递归，同solution02
 */
class Solution03 {

    int next = 0;

    public String decodeString(String s) {
        return dfs(s, 0);
    }

    private String dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        // k[a]
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '[') {
                // 开启递归
                String str = dfs(s, i + 1);
                // 继续遍历的位置
                i = next;
                while (multi-- > 0) {
                    res.append(str);
                }
                multi = 0;
            } else if (c == ']') {
                // 结束递归
                next = i;
                // 返回]之前的，给上一层重复使用
                return res.toString();
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
            } else {
                res.append(c);
            }
            i++;
        }
        return res.toString();
    }
}
