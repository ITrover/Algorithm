package everyday.licenseKeyFormatting;

/**
 * @author itrover
 * 482. 密钥格式化 https://leetcode-cn.com/problems/license-key-formatting/
 * 顺序处理，第一个单独处理
 */
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int charSize = s.length() - getNumOf(s);
        int first = charSize % k == 0 ? k : charSize % k;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 第一个单独处理
        while (sb.length() < first && i < s.length()) {
            if (s.charAt(i) != '-') {
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
            i++;
        }
        sb.append("-");
        int cnt = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '-') {
                sb.append(Character.toUpperCase(s.charAt(i)));
                cnt++;
                if (cnt % k == 0) {
                    sb.append("-");
                }
            }
            i++;
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    int getNumOf(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                cnt++;
            }
        }
        return cnt;
    }
}
