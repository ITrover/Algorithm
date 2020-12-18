package everyday.findTheDifference;

import java.util.Arrays;

/**
 * @author itrover
 * 389. 找不同 https://leetcode-cn.com/problems/find-the-difference/
 * 排序，直到找到不相同的字母
 * 时间复杂度o(nlog(n))
 * 空间复杂度o(n)
 */
class Solution {
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for(int i = 0; i < sArr.length; i++){
            if(sArr[i] != tArr[i]){
                return tArr[i];
            }
        }
        return tArr[tArr.length - 1];
    }
}
