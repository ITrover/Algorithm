package leetcode.numRabbits;

import java.util.Arrays;

/**
 * @author itrover
 * 781. 森林中的兔子 https://leetcode-cn.com/problems/rabbits-in-forest/
 * 贪心
 */
class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int res = 0;
        int i = 0;
        int n = answers.length;
        while (i < n) {
            int cnt = 0;
            int j = i;
            while (j < n && answers[j] == answers[i]) {
                j++;
                cnt++;
            }
            int last = cnt % (answers[i] + 1);
            // 整合相同的
            res += cnt - last;
            // 如果还有剩下，则将他们作为一组，向上取整
            res += last == 0 ? 0 : answers[i] + 1;
            i = j;
        }
        return res;
    }
}
