package bytedance.isSameTree;

/**
 * @author itrover
 * 100. 相同的树 https://leetcode-cn.com/problems/same-tree/
 * 递归
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return p == null ? q == null :
                q != null && (q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
