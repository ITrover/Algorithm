package everyday.letterCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author itrover
 * 17. 电话号码的字母组合 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 回溯
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<Character>[] maps = new ArrayList[8];
        for (int i = 0; i < 6; i++) {
            maps[i] = new ArrayList<>(3);
            for (int j = 0; j < 3; j++) {
                maps[i].add((char) ('a' + i * 3 + j));
            }
        }
        maps[5] = new ArrayList<>(Arrays.asList('p', 'q', 'r', 's'));
        maps[6] = new ArrayList<>(Arrays.asList('t', 'u', 'v'));
        maps[7] = new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z'));
        ArrayList<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, new StringBuilder(), res, maps);
        return res;
    }

    void dfs(String digits, int index, StringBuilder sb, List<String> res, List<Character>[] maps) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        List<Character> map = maps[digits.charAt(index) - '2'];
        for (Character character : map) {
            sb.append(character);
            dfs(digits, index + 1, sb, res, maps);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
