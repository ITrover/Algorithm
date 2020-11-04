package leetcode.deleteNode;

/**
 * @author itrover
 * 450. 删除二叉搜索树中的节点 https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 递归
 * 在当前层判断左右结点，并删除
 * h = log(n)
 * 时间复杂度o(h)
 * 空间复杂度o(h)
 */
class Solution2 {
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
        TreeNode t = new TreeNode(Integer.MAX_VALUE);
        t.left = root;
        dfs(t, key);
        return t.left;
    }

    void dfs(TreeNode root, int key) {
        if (root == null) {
            return;
        }
        // 判断左边
        if (root.right != null && root.right.val == key) {
            root.right = reshape(root.right);
        }
        // 判断右边
        if (root.left != null && root.left.val == key) {
            root.left = reshape(root.left);
        }
        // 根据根节点，判断走哪一边
        if (root.val > key) {
            dfs(root.left, key);
        } else {
            dfs(root.right, key);
        }
    }

    /**
     * @param root 待删除的结点
     */
    TreeNode reshape(TreeNode root) {
        if (root.right == null) {
            return root.left;
        }
        TreeNode p = root.right;
        while (p.left != null) {
            p = p.left;
        }
        p.left = root.left;
        return root.right;
    }
}
