package everyday.smallestStringWithSwaps;

import java.util.*;

/**
 * @author itrover
 * 1202. 交换字符串中的元素 https://leetcode-cn.com/problems/smallest-string-with-swaps/
 * 并查集
 */
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 不相交并查集
        DisjointSetUnion dsu = new DisjointSetUnion(s.length());
        // 构造
        for (List<Integer> pair : pairs) {
            dsu.unionSet(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
        for (int i = 0; i < s.length(); i++) {
            // 查找代表元
            int parent = dsu.find(i);
            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<Character>());
            }
            map.get(parent).add(s.charAt(i));
        }
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            // 对每一个不相交子集排序
            entry.getValue().sort((c1, c2) -> c2 - c1);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            // 获取代表元
            int x = dsu.find(i);
            // 从map中获取代表元对应的集合
            List<Character> list = map.get(x);
            // 取出当前元对应的子集中最小的一个
            sb.append(list.remove(list.size() - 1));
        }
        return sb.toString();
    }
}

class DisjointSetUnion {
    /**
     * 记录i的祖先
     */
    int[] f;
    /**
     * 记录i的子集中的元素个数
     */
    int[] rank;
    int n;

    public DisjointSetUnion(int n) {
        this.n = n;
        rank = new int[n];
        Arrays.fill(rank, 1);
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }

    /**
     * 递归寻找祖先
     * @param x
     * @return
     */
    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    public void unionSet(int x, int y) {
        int fx = find(x), fy = find(y);
        // 同一个祖先
        if (fx == fy) {
            return;
        }
        // 保证fx中的子集大于fy的
        if (rank[fx] < rank[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        // 让fy的祖先为fx
        f[fy] = fx;
    }
}
