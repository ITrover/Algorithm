package swordToOffer.pathSum;

import swordToOffer.codec.Codec;

import java.util.LinkedList;
import java.util.List;

/**
 * @author itrover
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * 二叉树的先序遍历
 * 中左右
 * 回溯
 */
class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null) {
            // 相加为tar，同时本结点时叶子结点
            // 是一条符合条件的路径
            res.add(new LinkedList<>(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        // 回溯，路径恢复
        path.removeLast();
    }

}