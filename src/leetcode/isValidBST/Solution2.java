package leetcode.isValidBST;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 98. 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 二叉树的中序遍历
 * 如果结果不是严格递增的，则不是二叉搜索树
 * 时间复杂度o(n + log(n))
 * 空间复杂度o(n + log(n))
 */
class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> items = new ArrayList<>();


    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i) >= items.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    void dfs(TreeNode root){
        if (root == null){
            return;
        }
        // 左
        dfs(root.left);
        // 中
        items.add(root.val);
        // 右
        dfs(root.right);
    }

}
