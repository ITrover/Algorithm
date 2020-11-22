package everyday.findRotateSteps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * dfs
 * 分别向左或右寻找最近位置，二叉树的最短路径查找
 * 时间复杂度o(2^n)
 * 空间复杂度o(n)
 */
class Solution2 {

    int res = Integer.MAX_VALUE;

    public int findRotateSteps(String ring, String key) {
        dfs(0, 0, key, 0, ring, true);
        dfs(0, 0, key, 0, ring, false);
        return res;
    }

    void dfs(int path, int start, String key, int i, String ring, boolean right) {
        if (i == key.length()) {
            res = Math.min(path, res);
            return;
        }
        // 剪枝
        if (path > res) {
            return;
        }
        int step = 1;
        int s = start;
        // 按照传入的方向搜素，直到找到ring中的字母
        while (ring.charAt(s) != key.charAt(i)) {
            s = rotate(ring.length(), s, right);
            step++;
        }
        // 继续向下搜索、往左和右方向
        dfs(path + step, s, key, i + 1, ring, true);
        dfs(path + step, s, key, i + 1, ring, false);
    }

    int rotate(int len, int i, boolean right) {
        return right ? (i + 1 == len ? 0 : i + 1) : (i == 0 ? len - 1 : i -1);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        long start = System.currentTimeMillis();
        System.out.println(solution.findRotateSteps("xrrakuulnczywjs", "jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr"));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
