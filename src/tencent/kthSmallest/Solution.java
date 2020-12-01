package tencent.kthSmallest;

/**
 * @author itrover
 * 230. 二叉搜索树中第K小的元素 https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 中序遍历
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

    int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k);
    }

    int dfs(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, k);
        cnt++;
        if (cnt == k) {
            return root.val;
        }
        int right = dfs(root.right, k);
        // 其中某个可能会携带目标值返回，否则都为0，则返回0
        return Math.max(left, right);
    }
}
