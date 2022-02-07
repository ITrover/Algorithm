package everyday.longestDiverseString;

import java.util.Arrays;

/**
 * 1405. 最长快乐字符串 https://leetcode-cn.com/problems/longest-happy-string/
 * 贪心算法，每次选择最多的字母
 */
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        Pair[] arr = new Pair[]{new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c')};
        boolean hasNext = false;
        do {
            // 由大到小
            Arrays.sort(arr, (e1, e2) -> e2.num - e1.num);
            for (Pair pair : arr) {
                // 没有字母了
                if (pair.num <= 0) {
                    hasNext = false;
                    break;
                }
                int m = res.length();
                // 如果当前的字母与之前的两个字母一样就换一个字母
                if (m >= 2 && res.charAt(m - 2) == pair.ch && res.charAt(m - 1) == pair.ch) {
                    continue;
                }
                res.append(pair.ch);
                hasNext = true;
                pair.num--;
                break;
            }

        } while (hasNext);
        return res.toString();
    }

    private class Pair {
        int num;
        char ch;

        public Pair(int num, char ch) {
            this.num = num;
            this.ch = ch;
        }
    }
}
