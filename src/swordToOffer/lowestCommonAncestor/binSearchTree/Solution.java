package swordToOffer.lowestCommonAncestor.binSearchTree;

/**
 * 二叉搜索树的公共祖先
 *
 * 迭代
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


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // p,q 都在 root 的右子树中
            if (root.val < p.val && root.val < q.val) {
                // 遍历至右子节点
                root = root.right;
                // p,q 都在 root 的左子树中
            } else if (root.val > p.val && root.val > q.val) {
                // 遍历至左子节点
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}