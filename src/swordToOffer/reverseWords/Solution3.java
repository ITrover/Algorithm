package swordToOffer.reverseWords;


/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/8/5 20:36
 */


/**
 * 先翻转整个字符串
 * 再翻转每个单词
 */
class Solution3 {
    /**
     * 翻转字符串
     * @param s
     * @return
     */
    String reverse(String s){
        int len = s.length();
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            res[len - i - 1] = s.charAt(i);
        }
        return new String(res);
    }

    public String reverseWords(String s) {
        s = reverse(s.trim());
        int start = 0;
        int end = 0;
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        while (start < length) {
            while (end < length && s.charAt(end) != ' '){
                end ++;
            }
            // start为单词的第一个字符
            // end为单词后面第一个空格
            sb.append(reverse(s.substring(start,end)));
            sb.append(' ');
            while(end <length && s.charAt(end) == ' '){
                end ++;
            }

            while (start < length && s.charAt(start) != ' '){
                start ++;
            }
            while(start <length && s.charAt(start) == ' '){
                start ++;
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.reverseWords("the sky is blue"));
    }
}
