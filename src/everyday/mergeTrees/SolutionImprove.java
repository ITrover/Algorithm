package everyday.mergeTrees;


/**
 * 优化代码
 * 时间复杂度o(n)
 * 空间复杂度o(log(n))
 */
class SolutionImprove {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1, t2);
    }

    /**
     * 1. 两个都不为空 --- > 退出
     * 2. 一个为空，一个不为空 --- > 不为空的值
     * 3. 两个都为空了 --- > 相加
     *
     * @param t1
     * @param t2
     */
    TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }
        TreeNode newTree = new TreeNode(t1.val + t2.val);
        newTree.left = dfs(t1.left, t2.left);
        newTree.right = dfs(t1.right, t2.right);
        return newTree;
    }
}