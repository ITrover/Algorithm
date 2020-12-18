package everyday.findTheDifference;


/**
 * @author itrover
 * 389. 找不同 https://leetcode-cn.com/problems/find-the-difference/
 * 计数
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution2 {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        // 统计每个数出现的次数
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }
        // 找到让计数为负的字母，该字母就是插入的
        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i) - 'a']--;
            if (cnt[t.charAt(i) - 'a'] < 0){
                return t.charAt(i);
            }
        }
        return ' ';
    }
}
