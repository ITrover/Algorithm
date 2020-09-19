package everyday.sumOfLeftLeaves;

/**
 * @author itrover
 * 404. 左叶子之和(https://leetcode-cn.com/problems/sum-of-left-leaves/)
 * 递归
 * 左叶子结点的判定
 */
class Solution {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // 判断左子树的依据
        // 当前结点只有左结点，同时子节点的左右结点都为null
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}