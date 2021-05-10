package everyday.leafSimilar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 872. 叶子相似的树 https://leetcode-cn.com/problems/leaf-similar-trees/
 * 递归
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        findLeaf(root1, leaf1);

        List<Integer> leaf2 = new ArrayList<>();
        findLeaf(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    void findLeaf(TreeNode root, List<Integer> leaf) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
        }
        findLeaf(root.left, leaf);
        findLeaf(root.right, leaf);
    }
}
