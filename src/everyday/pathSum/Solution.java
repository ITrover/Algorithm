package everyday.pathSum;


/**
 * @author itrover
 * 437. 路径总和 III https://leetcode-cn.com/problems/path-sum-iii/
 * 深度优先，以不同的结点为起点
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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 以根为起点
        int ret = rootSum(root, targetSum);
        // 以左右为起点递归搜索
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        targetSum -= val;
        if (targetSum == 0) {
            ret++;
        }
        ret += rootSum(root.left, targetSum);
        ret += rootSum(root.right, targetSum);
        return ret;
    }
}
