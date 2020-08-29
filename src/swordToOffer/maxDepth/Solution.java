package swordToOffer.maxDepth;

import java.util.ArrayDeque;

/**
 * 二叉树按层次遍历
 * 时间复杂度o(n)
 * 空间复杂度o(log(n))
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> layers = new ArrayDeque<>();
        int res = 0;
        layers.addLast(root);
        while (!layers.isEmpty()) {
            // 当前层的结点个数
            int size = layers.size();
            // 遍历当前层
            for (int i = 0; i < size; i++) {
                TreeNode node = layers.pop();
                if (node.left != null) {
                    layers.addLast(node.left);
                }
                if (node.right != null) {
                    layers.addLast(node.right);
                }
            }
            // 每遍历一层就加1
            res++;
        }
        return res;
    }
}