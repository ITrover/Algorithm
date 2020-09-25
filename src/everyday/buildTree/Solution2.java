package everyday.buildTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 106. 从中序与后序遍历序列构造二叉树(https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
 * 联系剑指offer{@link swordToOffer.buildTree}
 * 通过后序遍历找到根结点
 * 通过中序遍历找到左右子树的结点
 * 递归
 * 通过HashMap提高效率
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, map, 0, inorder.length - 1, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> map, int il, int ir, int pr) {
        if (il > ir) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[pr]);
        int i = map.get(postorder[pr]);
        node.left = buildTree(postorder, map, il, i - 1, pr - ir + i - 1);
        node.right = buildTree(postorder, map, i + 1, ir, pr - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        Solution2 solution = new Solution2();
        solution.buildTree(inorder, postorder);
    }
}