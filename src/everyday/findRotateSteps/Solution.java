package everyday.findRotateSteps;

import java.util.ArrayDeque;


/**
 * @author itrover
 * 514. 自由之路 https://leetcode-cn.com/problems/freedom-trail/
 * bfs
 * 超出内存限制
 * 时间复杂度o(2^n)
 * 空间复杂度o(2^n)
 */
class Solution {

    int res = Integer.MAX_VALUE;

    public int findRotateSteps(String ring, String key) {
        int i = 0;
        int s = 0;
        int rLen = ring.length();
        // BFS
        // 二叉树的最短路径
        ArrayDeque<int[]> path = new ArrayDeque<>();
        path.addLast(new int[]{0, 0});
        while (i < key.length()) {
            // 分别向两边搜索
            int size = path.size();
            for (int j = 0; j < size; j++) {
                int[] node = path.pollFirst();
                // 起点
                s = node[1];
                int step = 1;
                // 顺时针旋转
                while (ring.charAt(s) != key.charAt(i)) {
                    s = rotate(rLen, s, true);
                    step++;
                }
                path.addLast(new int[]{node[0] + step, s});

                // 起点
                s = node[1];
                step = 1;
                // 逆时针旋转
                while (ring.charAt(s) != key.charAt(i)) {
                    s = rotate(rLen, s, false);
                    step++;
                }
                path.addLast(new int[]{node[0] + step, s});
            }
            i++;
        }
        int min = Integer.MAX_VALUE;
        for (int[] node : path) {
            min = Math.min(node[0], min);
        }
        return min;
    }


    int rotate(int len, int i, boolean right) {
        if (right) {
            if (i + 1 == len) {
                return 0;
            }
            return i + 1;
        }
        if (i == 0) {
            return len - 1;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRotateSteps("godding", "gdg"));
    }

}
