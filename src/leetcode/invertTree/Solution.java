package leetcode.invertTree;

/**
 * @author itrover
 * 226. 翻转二叉树 https://leetcode-cn.com/problems/invert-binary-tree/
 * 递归复杂度o(n)
 * 空间复杂度o(n)
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

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        // 翻转左右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
