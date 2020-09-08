package everyday.combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/8 15:47
 * @description 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * 递归
 */
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] container = new int[k];
        add(n, 0, 1, k, container);
        return res;
    }

    /**
     * @param n         一共的数字
     * @param i         当前位数
     * @param m         当前到达的数字
     * @param k         每组数的个数
     * @param container 保存结果的
     */
    public void add(int n, int i, int m, int k, int[] container) {
        if (i == k) {
            // 添加结果
            res.add(Arrays.stream(container).boxed().collect(Collectors.toList()));
            return;
        }
        // 还需要填充的个数，小于能够用于填充的个数，无法填充了
        if (k - i - 1 > n - m) {
            return;
        }
        for (int j = m; j <= n; j++) {
            // 设置当前位的值
            container[i] = j;
            // 设置后面位，同时将可用数字往后推
            add(n, i + 1, j + 1, k, container);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(2, 1));
    }
}
