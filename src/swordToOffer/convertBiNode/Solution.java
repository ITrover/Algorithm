package swordToOffer.convertBiNode;

/**
 * @author itrover
 * 面试题 17.12. BiNode(https://leetcode-cn.com/problems/binode-lcci/)
 * 二叉树的中序遍历
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

    TreeNode res = null;
    TreeNode cur = null;

    public TreeNode convertBiNode(TreeNode root) {
        dfs(root);
        if (res != null){
            cur.right = null;
        }
        return res;
    }

    void dfs(TreeNode root){
        if (root == null){
            return;
        }
        // 左
        dfs(root.left);
        // 自己
        if (res == null){
            res = root;
        }else {
            cur.right = root;
        }
        cur = root;
        // 设置左边为null，避免循环
        cur.left = null;
        dfs(root.right);
        // 右
    }
}