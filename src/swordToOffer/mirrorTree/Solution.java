package swordToOffer.mirrorTree;

/**
 * 树的镜像
 *  递归法
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

    public TreeNode mirrorTree(TreeNode root) {
        // 递归法，如果有子节点,那么交换左右结点
        if (root != null){
            if (root.left != null || root.right != null){
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                mirrorTree(root.left);
                mirrorTree(root.right);
            }
        }
        return root;
    }

}
