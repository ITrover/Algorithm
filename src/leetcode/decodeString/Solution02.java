package leetcode.decodeString;

/**
 * @author itrover
 * 394. 字符串解码 https://leetcode-cn.com/problems/decode-string/
 * 递归
 */
class Solution02 {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            } else if(s.charAt(i) == '[') {
                // 获得重复的部分
                String[] tmp = dfs(s, i + 1);
                // 下一次遍历的位置
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']') {
                // 返回重复部分和下一次遍历的位置
                return new String[] { String.valueOf(i), res.toString() };
            } else {
                res.append(s.charAt(i));
            }
            i++;
        }
        return new String[] { res.toString() };
    }
}
