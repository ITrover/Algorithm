package tencent.maxPathSum;

/**
 * @author itrover
 * 124. 二叉树中的最大路径和 https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 递归
 * 时间复杂度o(n)
 * 空间复杂度o(h)// h为递归的最大深度
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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 后序遍历
        // 获得左右的最长路径
        int leftC = dfs(root.left);
        int rightC = dfs(root.right);
        // 只要大于0的左右路径
        leftC = Math.max(0, leftC);
        rightC = Math.max(0, rightC);
        // 加上当前结点可以构成的最大路径
        int count = Math.max(root.val, leftC + rightC + root.val);
        // 更新最长路径
        max = Math.max(max, count);
        // 对于上一个结点来说，上一个结点和当前结点的左右结点不可同时构成路径
        // 因此如果左右结点在本层都用上了，要删掉最小值
        return  count - Math.min(leftC, rightC);
    }
}
