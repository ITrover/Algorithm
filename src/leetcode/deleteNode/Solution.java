package leetcode.deleteNode;

/**
 * @author itrover
 * 450. 删除二叉搜索树中的节点 https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 递归
 * 判断当前结点是否被删除，返回删除后的根结点
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode right = deleteNode(root.right,key);
        TreeNode left = deleteNode(root.left,key);
        if (root.val == key){
            // 删除结点
            if (right == null){
                return left;
            }
            TreeNode p = right;
            while (p.left != null){
                p = p.left;
            }
            p.left = left;
            return right;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
