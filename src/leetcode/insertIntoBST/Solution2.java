package leetcode.insertIntoBST;

/**
 * @author itrover
 * 701. 二叉搜索树中的插入操作(https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)
 */
class Solution2 {
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
        if (root == null){
            return new TreeNode(val);
        }
        // 如果val大于当前结点，则插在右边
        if (val > root.val){
            root.right = insertIntoBST(root.right,val);
        }else{
            // 如果val小于当前结点，插在左边。
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}