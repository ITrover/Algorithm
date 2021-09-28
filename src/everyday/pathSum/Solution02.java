package everyday.pathSum;


import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 437. 路径总和 III https://leetcode-cn.com/problems/path-sum-iii/
 * 深度优先，以不同的结点为起点
 */
class Solution02 {
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

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        // 前缀和
        curr += root.val;
        // 判断前缀和中是否有值为curr - targetSum的前缀和，即当前前缀和该前缀中间的和为targetSum
        ret = prefix.getOrDefault(curr - targetSum, 0);
        // 添加从root到当前节点的前缀和
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        // 删除从root到当前节点的前缀和
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}
