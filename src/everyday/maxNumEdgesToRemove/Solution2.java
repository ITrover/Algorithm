package everyday.maxNumEdgesToRemove;

import java.util.Arrays;

/**
 * @author itrover
 * 1579. 保证图可完全遍历 https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
 * 并查集
 * 空间换时间
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution2 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // 如果边的数量少于 n - 1,则不可能连通
        if (n - 1 > edges.length) {
            return -1;
        }
        int res = 0;
        // 分别持有两个并查集
        DisjointSetUnion alice = new DisjointSetUnion(n + 1);
        DisjointSetUnion bob = new DisjointSetUnion(n + 1);
        DisjointSetUnion total = new DisjointSetUnion(n + 1);
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][1];
            int y = edges[i][2];
            if (edges[i][0] == 1) {
                // alice
                res += bToi(alice.unionSet(x, y));
            } else if (edges[i][0] == 2) {
                // bob
                res += bToi(bob.unionSet(x, y));
            } else {
                // 分两种情况，公共和专有
                if (total.unionSet(x,y)){
                    res++;
                }else{
                    res += bToi(alice.unionSet(x, y));
                    res += bToi(bob.unionSet(x, y));
                }
            }
        }
        // 检查alice 或者 bob 能不能走遍图
        return canVisit(alice) && canVisit(bob) ? res : -1;
    }

    int bToi(boolean x) {
        return x ? 1 : 0;
    }

    /**
     * 是否在一个强连通分支中
     *
     * @param union
     * @return
     */
    boolean canVisit(DisjointSetUnion union) {
        int f = union.find(1);
        for (int i = 2; i < union.n; i++) {
            if (union.find(i) != f) {
                return false;
            }
        }
        return true;
    }

    class DisjointSetUnion {
        /**
         * 记录i的祖先
         */
        int[] f;
        /**
         * 记录i的子集中的元素个数
         */
        int[] nums;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            nums = new int[n];
            Arrays.fill(nums, 1);
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        /**
         * 递归寻找祖先
         *
         * @param x
         * @return
         */
        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        /**
         * @param x
         * @param y
         * @return true  两个点之前连通了
         * false 两个点之前不连通
         */
        public boolean unionSet(int x, int y) {
            int fx = find(x), fy = find(y);
            // 同一个祖先
            if (fx == fy) {
                return true;
            }
            // 保证fx中的子集大于fy的
            // 由于每次被合的都是最小的，同时修改的是代表元的父元素
            // 所以能够保证同一个子集中的代表元最终都是一致的
            if (nums[fx] < nums[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            nums[fx] += nums[fy];
            // 让fy的祖先为fx
            f[fy] = fx;
            return false;
        }
    }
}
