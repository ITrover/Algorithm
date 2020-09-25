package everyday.buildTree;

/**
 * @author itrover
 * 106. 从中序与后序遍历序列构造二叉树(https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
 *
 * 联系剑指offer{@link swordToOffer.buildTree}
 * 通过后序遍历找到根结点
 * 通过中序遍历找到左右子树的结点
 * 递归
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int il, int ir, int pr) {
        if (il > ir) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[pr]);
        int i = 0;
        for (int j = il; j <= ir; j++) {
            if (inorder[j] == postorder[pr]) {
                break;
            }
        }
        node.left = buildTree(inorder, postorder, il, i - 1, pr - ir + i - 1);
        node.right = buildTree(inorder, postorder, i + 1, ir, pr - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        Solution solution = new Solution();
        solution.buildTree(inorder,postorder);
    }
}