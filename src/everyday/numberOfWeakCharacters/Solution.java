package everyday.numberOfWeakCharacters;

import java.util.Arrays;

/**
 * @author itrover
 * 1996. 游戏中弱角色的数量 https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/
 * 排序 时间复杂度o(n^2)
 */
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // 攻击力由大到小
        // 防御力由小到大
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]));
        int maxDef = 0;
        int ans = 0;
        // 只用记录最大的防御力
        // 因为前面的攻击力一定大于后面的攻击力
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }
}
