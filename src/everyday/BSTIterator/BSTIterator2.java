package everyday.BSTIterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器 https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * @author itrover
 */
class BSTIterator2 {

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

    TreeNode cur;
    Stack<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        // 左 中 右
        stack = new Stack<>();
        cur = root;
    }

    public int next() {
        while (cur != null) {
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }
}
