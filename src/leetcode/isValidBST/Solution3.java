package leetcode.isValidBST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author itrover
 * 98. 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 层序遍历迭代法判断上下界 o(n)
 */
public class Solution3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Queue<Integer> min = new LinkedList<>();
        Queue<Integer> max = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            Integer maxt = max.poll();
            Integer mint = min.poll();

            if (mint != null && temp.val <= mint) {
                return false;
            }
            if (maxt != null && temp.val >= maxt) {
                return false;
            }

            if (temp.left != null) {
                min.add(mint);
                max.add(temp.val);
                queue.add(temp.left);
            }

            if (temp.right != null) {
                max.add(maxt);
                min.add(temp.val);
                queue.add(temp.right);
            }
        }
        return true;
    }

}
