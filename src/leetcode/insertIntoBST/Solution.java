package leetcode.insertIntoBST;

/**
 * @author itrover
 * 701. 二叉搜索树中的插入操作(https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)
 * 二叉树的先序遍历
 */
class Solution {
    private class TreeNode {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        maxNode = root;
        if(dfs(root, val) == null){
            // 如果为空那么右两种情况
            // root为空
            if (root == null){
                return new TreeNode(val);
            }
            // root的值都小于val
            // 找到当前树最大的结点，插在右边
            maxNode.right = new TreeNode(val);
        }

        return root;
    }

    private TreeNode maxNode = null;

    /**
     * 寻找到root中第一个大于val的位置
     * 如果找到，就插入
     * 如果没有，返回null
     * @param root
     * @param val
     * @return
     */
    TreeNode dfs(TreeNode root, int val){
        if (root == null){
            return null;
        }
        TreeNode left = dfs(root.left, val);
        if (left != null){
            return left;
        }

        // 找到最大结点的位置
        if (maxNode.val < root.val){
            maxNode = root;
        }

        // 找到第一个大于val的位置
        if (root.val > val){
            // 此处就是插入的位置
            // 如果该结点由左子树，那么左子树小于val
            // 如果该结点无左子树，那么就把当前值插到左边
            // 无论如何都是插在左边
            TreeNode tmp = root.left;
            root.left = new TreeNode(val,tmp,null);
            return root;
        }
        return dfs(root.right,val);
    }
}