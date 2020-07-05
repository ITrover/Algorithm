package swordToOffer.replaceSpace;

/**
 * 使用临时数组
 */
class Solution {
    public String replaceSpace(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                str.append("%20");
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}
