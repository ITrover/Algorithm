package everyday.sortString;

/**
 * @author itrover
 * 1370. 上升下降字符串 https://leetcode-cn.com/problems/increasing-decreasing-string/
 * 借助数组
 */
class Solution {
    public String sortString(String s) {
        int[] chars = new int[26];
        for(int i = 0;i < s.length(); i++){
            chars[s.charAt(i) - 'a']++;
        }
        StringBuilder str = new StringBuilder();
        int last = s.length();
        while(last > 0){
            for(int i = 0; i < 26; i++){
                if(chars[i] > 0){
                    str.append((char)('a' + i));
                    chars[i] --;
                    last--;
                }
            }
            for(int i = 25; i >= 0; i--){
                if(chars[i] > 0){
                    str.append((char)('a' + i));
                    chars[i] --;
                    last--;
                }
            }
        }
        return str.toString();
    }
}
