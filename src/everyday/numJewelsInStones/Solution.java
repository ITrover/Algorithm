package everyday.numJewelsInStones;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 771. 宝石与石头(https://leetcode-cn.com/problems/jewels-and-stones/)
 * Hash表
 * 时间复杂度o(n)
 * 空间复杂度o(m)
 */
class Solution {
    /**
     * @param J 宝石类型
     * @param S 石头
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}