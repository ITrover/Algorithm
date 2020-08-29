package swordToOffer.kthLargest;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *  时间复杂度o(n)
 *  空间复杂度o(1)
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

    List<Integer> nodes = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        visit(root);
        // 获取倒数第k个，即为第k个最大值
        return nodes.get(nodes.size() - k);
    }

    void visit(TreeNode root){
        if (root == null){
            return;
        }
        visit(root.left);
        nodes.add(root.val);
        visit(root.right);
    }

}