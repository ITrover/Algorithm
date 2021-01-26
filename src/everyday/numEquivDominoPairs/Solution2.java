package everyday.numEquivDominoPairs;

/**
 * @author itrover
 * 1128. 等价多米诺骨牌对的数量 https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 * 数组 + 计数
 */
class Solution2 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
