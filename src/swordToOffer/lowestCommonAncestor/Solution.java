package swordToOffer.lowestCommonAncestor;

/**
 * 递归，后序遍历
 * 时间复杂度 o(n)
 * 空间复杂度 o(n),递归深度
 * 三种情况
 *  1. p和q在root子树中，且分别在root的两侧
 *  2. p == root ，且q在root的左或右子树中
 *  3. q == root ，且p在root的左或右子树中
 *
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        // left和right都不为null
        // 说明左右子树分别是p和q
        // 当前结点为根
        return root;
    }
}