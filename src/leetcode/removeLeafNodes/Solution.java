package leetcode.removeLeafNodes;

/**
 * @author itrover
 * 1325. 删除给定值的叶子节点 https://leetcode-cn.com/problems/delete-leaves-with-a-given-value/
 * 递归
 * 时间复杂度o(n)
 * 空间复杂度o(n)
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

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null){
            return null;
        }
        // 删除左子树满足条件的叶子结点
        root.left = removeLeafNodes(root.left,target);

        // 删除右子树满足条件的叶子结点
        root.right = removeLeafNodes(root.right,target);

        // 删除当前结点，一定要放在最后
        // 一旦左右子树都被删除了，当前结点会变成叶子结点，如果满足条件就删除
        if (root.val == target && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}
