package everyday.BSTIterator;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 173. 二叉搜索树迭代器 https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * 中序遍历
 * @author itrover
 */
class BSTIterator {

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

    ArrayList<Integer> iterator;
    int index;

    public BSTIterator(TreeNode root) {
        iterator = new ArrayList<>();
        // 中序遍历，左 中 右
        LinkedList<TreeNode> nodes = new LinkedList<>();
        while (root != null || !nodes.isEmpty()) {
            if (root == null) {
                root = nodes.pollLast();
                // 此时，左边已经走到底了，中
                iterator.add(root.val);
                // 右
                root = root.right;
            }
            // 左边有，一直往左
            while (root != null) {
                nodes.addLast(root);
                root = root.left;
            }
        }
    }

    public int next() {
        // 中左右
        return iterator.get(index++);
    }

    public boolean hasNext() {
        return index < iterator.size();
    }
}
