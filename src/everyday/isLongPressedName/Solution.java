package everyday.isLongPressedName;


/**
 * @author itrover
 * 925. 长按键入 https://leetcode-cn.com/problems/long-pressed-name/
 * 字符串匹配
 * 双指针
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()){
            if (i < name.length() && name.charAt(i) == typed.charAt(j)){
                i--;
                j--;
            }else if(j > 0 && typed.charAt(j) == typed.charAt(j - 1)){
                j--;
            }else{
                return false;
            }
        }
        return i == name.length();
    }
}
