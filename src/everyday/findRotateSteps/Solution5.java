package everyday.findRotateSteps;


import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * dfs
 * 超时了
 */
class Solution5 {

    int res = Integer.MAX_VALUE;

    List<Integer>[] location = new ArrayList[26];

    public int findRotateSteps(String ring, String key) {
        List<Integer>[] map = new List[26];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < ring.length(); i++) {
            map[ring.charAt(i) - 'a'].add(i);
        }
        return dfs(key, map, 0, 0, ring.length());

    }

    private int dfs(String key, List<Integer>[] map, int index, int start, int ringLen) {
        if (index == key.length()) {
            return 0;
        }
        List<Integer> list = map[key.charAt(index) - 'a'];
        int min = 0x3f3f3f3f;
        // 到下一步的最小距离
        for (Integer next : list) {
            min = Math.min(getDis(start, next, ringLen) + dfs(key, map, index + 1, next, ringLen), min);
        }
        return min;
    }

    private int getDis(int start, int next, int ringLen) {
        return Math.min(Math.abs(next - start), ringLen - Math.abs(next - start)) + 1;
    }
}
