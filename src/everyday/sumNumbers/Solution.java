package everyday.sumNumbers;

import java.util.Deque;

/**
 * @author itrover
 * 129. 求根到叶子节点数字之和 https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * DFS
 * 先序遍历
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int pathSum) {
        if (root == null) {
            return;
        }
        pathSum *= 10;
        pathSum += root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            res += pathSum;
            return;
        }
        dfs(root.left, pathSum);
        dfs(root.right, pathSum);
    }
}
