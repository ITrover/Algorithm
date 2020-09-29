package everyday.postorderTraversal;


import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历(https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)
 * 使用递归实现
 */
class Solution {
    public class TreeNode {
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
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return res;
        }
        // 左
        postorderTraversal(root.left);
        // 右
        postorderTraversal(root.right);
        // 中
        res.add(root.val);
        return res;
    }
}