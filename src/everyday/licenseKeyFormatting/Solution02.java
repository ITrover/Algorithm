package everyday.licenseKeyFormatting;

/**
 * @author itrover
 * 482. 密钥格式化 https://leetcode-cn.com/problems/license-key-formatting/
 * 逆序处理
 */
class Solution02 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.reverse().toString();
    }
}
