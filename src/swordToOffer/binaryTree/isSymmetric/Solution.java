package swordToOffer.binaryTree.isSymmetric;

import swordToOffer.binaryTree.codec.Codec;

/**
 * 递归
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

    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    /**
     * 递归判断
     * 对称条件判断
     * @param l
     * @param r
     * @return
     */
    public boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }

        if (l == null || r == null || l.val != r.val) {
            return false;
        }
        return recur(l.left, r.right) && recur(l.right, r.left);

    }
}
