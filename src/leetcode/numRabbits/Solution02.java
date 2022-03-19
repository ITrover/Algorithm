package leetcode.numRabbits;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 781. 森林中的兔子 https://leetcode-cn.com/problems/rabbits-in-forest/
 * 贪心
 */
class Solution02 {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey(), y = entry.getValue();
            // 组数 * 个数
            // 向上取整
            res += (x + y) / (y + 1) * (y + 1);
        }
        return res;
    }
}
