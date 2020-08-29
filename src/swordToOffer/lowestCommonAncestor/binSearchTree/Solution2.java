package swordToOffer.lowestCommonAncestor.binSearchTree;

/**
 * 二叉搜索树的公共祖先
 *
 * 递归
 * 时间复杂度o(n)
 * 空间复杂度o(n)，递归深度
 */
class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

}