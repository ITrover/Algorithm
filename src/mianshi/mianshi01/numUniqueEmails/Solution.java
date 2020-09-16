package mianshi.mianshi01.numUniqueEmails;

import java.util.HashSet;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/16 18:28
 * @description 独特的电子邮件地址
 */
public class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            String validate = validate(emails[i]);
            set.add(validate);
        }
        return set.size();
    }

    String validate(String email) {
        String[] split = email.split("@");
        char[] chars = split[0].toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == '+') {
                break;
            }
            if (aChar != '.') {
                builder.append(aChar);
            }
        }
        builder.append("@");
        builder.append(split[1]);
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"});
    }
}
