package everyday.makeConnected;

import java.util.Arrays;

/**
 * @author itrover
 * 1319. 连通网络的操作次数 https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
 * 并查集
 */
class Solution {
    public int makeConnected(int n, int[][] connections) {
        // 只有当边的个数 >= n - 1才可能全部连通
        if (connections.length < n - 1) {
            return -1;
        }
        DisjointSetUnion union = new DisjointSetUnion(n);
        // 记录有效的连接
        int res = 0;
        for (int[] connection : connections) {
            // 如果两个点不在同一个连通分支
            // 则够不成环
            if (!union.unionSet(connection[0], connection[1])) {
                res++;
            }
        }
        // 需要调整的边为一共需要的边 - 无环的边
        return n - res - 1;
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
