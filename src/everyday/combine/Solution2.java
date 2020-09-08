package everyday.combine;

import java.util.*;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/8 15:47
 * @description 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * 递归
 * 使用list改进
 */
class Solution2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        ArrayDeque<Integer> container = new ArrayDeque<>(k);
        dfs(n, 1, k, container);
        return res;
    }

    /**
     * @param n         一共的数字
     * @param m         当前到达的数字
     * @param k         每组数的个数
     * @param container 保存结果的
     */
    public void dfs(int n, int m, int k, Deque<Integer> container) {
        if (container.size() == k) {
            // 添加结果
            res.add(new ArrayList<>(container));
            return;
        }
        // n - (k - container.size()) + 1
        // 是减枝操作，省去没有意义的循环
        for (int j = m; j <= n - (k - container.size()) + 1; j++) {
            // 设置当前位的值
            container.addLast(j);
            // 设置后面位，同时将可用数字往后推
            dfs(n, j + 1, k, container);
            container.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.combine(4, 2));
    }
}
