package everyday.preorderTraversal;


import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 144. 二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * morris traversal 方法
 * 中 左 右
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root, pre = null;
        while (cur != null) {
            pre = cur.left;
            if (pre != null) {
                // 当前结点有左子树
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // 构建线索
                if (pre.right == null) {
                    res.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                    // 这里是关键，有左子树，那么一直访问下去
                    continue;
                } else {
                    // 拆除线索
                    pre.right = null;
                }
            } else {
                // 当前结点无左子树
                res.add(cur.val);
            }
            cur = cur.right;
        }
        return res;
    }
}
