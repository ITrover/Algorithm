package swordToOffer.reverseWords;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/8/1 21:32
 */

class Solution2 {
    public String reverseWords(String s) {
        s.trim();
        int i = s.length() - 1;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }
}
