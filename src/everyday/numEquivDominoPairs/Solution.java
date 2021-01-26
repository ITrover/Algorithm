package everyday.numEquivDominoPairs;

/**
 * @author itrover
 * 1128. 等价多米诺骨牌对的数量 https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 * Map
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] map = new int[10][10];
        for (int[] dominoe : dominoes) {
            if (dominoe[0] < dominoe[1]) {
                map[dominoe[0]][dominoe[1]]++;
            } else {
                map[dominoe[1]][dominoe[0]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = i; j < map[i].length; j++) {
                res += (map[i][j] * (map[i][j] - 1)) / 2;
            }
        }
        return res;
    }
}
