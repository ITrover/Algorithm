package leetcode.rob.improve2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 337. 打家劫舍 III https://leetcode-cn.com/problems/house-robber-iii/
 * dfs
 */
class Solution2 {

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

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        // 选中当前就不能选左右
        int select = node.val + l[1] + r[1];
        // 不选择当前能够获得的最大值=左右的最大值之和
        int notSelect = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[] {select, notSelect};
    }
}
