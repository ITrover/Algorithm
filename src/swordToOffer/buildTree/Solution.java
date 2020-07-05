package swordToOffer.buildTree;


//Definition for a binary tree node.

import sun.plugin.AppletStatusListener;

import java.util.HashMap;

/**
 * 使用递归
 * 编写思虑
 * 绘制图解
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 递归
        HashMap<Integer, Integer> map = new HashMap<>();
        // 通过节点的值找到位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, map, 0, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> map, int index, int start, int end) {
        if (index < 0 || index >= preorder.length || start > end) {
            // 退出条件
            return null;
        }
        // 每次保留根节点
        TreeNode node = new TreeNode(preorder[index]);
        // 再中序序列中找到左右字数的根节点
        int mid = map.get(preorder[index]);
        // 左子树大小
        int leftLength = Math.max(mid - start, 0);
        // 左子树开始的点
        int leftStart = index + 1;
        node.left = buildTree(preorder, map, leftStart, start, mid - 1);
        // 右子树开始的点
        int rightStart = index + 1 + leftLength;
        node.right = buildTree(preorder, map, rightStart, mid + 1, end);
        // 返回根节点
        return node;
    }

    public static void main(String[] args) {
/*        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};*/
        int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{3, 2, 1};
        Solution solution = new Solution();
        TreeNode tree = solution.buildTree(preorder, inorder);

    }

}
