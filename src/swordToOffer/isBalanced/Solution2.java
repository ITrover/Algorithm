package swordToOffer.isBalanced;

/**
 * 后序遍历
 * 一边遍历，一边判断是否符合平衡二叉树
 */
class Solution2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 用于判断是否为平衡二叉树
     */
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return flag;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 分别得到左右子树的最大深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int diff = left - right;
        if(diff > 1 || diff < -1){
            flag = false;
        }
        return left > right ? left + 1 : right + 1;
    }

}