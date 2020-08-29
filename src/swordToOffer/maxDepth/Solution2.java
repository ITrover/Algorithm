package swordToOffer.maxDepth;

import java.util.ArrayDeque;

/**
 * 递归
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 * 没一个树的最大深度等于，深度最大的子树 + 1
 */
class Solution2 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 当前树的最大深度
        return left > right ? (left + 1) : (right + 1);
    }
}