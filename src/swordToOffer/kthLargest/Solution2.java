package swordToOffer.kthLargest;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历的逆序遍历
 *  右 中 左
 *  提前返回
 *  时间复杂度o(n)
 *  空间复杂度o(1)
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


    int k,res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        visit(root);
        return res;
    }

    void visit(TreeNode root){
        if (root == null){
            return;
        }
        // 先访问右边
        visit(root.right);
        if(k == 0) {
            return;
        }
        if(--k == 0) {
            res = root.val;
        }
        visit(root.left);
    }

}