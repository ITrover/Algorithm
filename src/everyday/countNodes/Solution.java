package everyday.countNodes;

/**
 * @author itrover
 * 222. 完全二叉树的节点个数 https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 利用完全二叉树的特性
 * 位运算、二分查找
 * 时间复杂度o(log^2(n))
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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // 第level层最少low个，最多high个
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     *
     * @param root 根结点
     * @param level 层数
     * @param k 第k个结点
     * @return
     */
    public boolean exists(TreeNode root, int level, int k) {
        // 100。。
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            // 0左，1右
            // 判断k从左到右的每一位是否为0
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
