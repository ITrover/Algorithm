package everyday.findMode;


import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数(https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/)
 * 二叉树的前序遍历
 * 前序遍历访问二叉搜索树，访问的顺序是递增的
 * 相同数字连续出现
 */
class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 当前出现最多的次数
     */
    private int maxCount = 0;
    private int count = 0;
    private int num = 0;
    private List<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            mode[i] = res.get(i);
        }
        return mode;
    }

    /**
     * 二叉树的中序遍历
     * @param root
     */
    void dfs(TreeNode root){
        if (root == null){
            return;
        }
        // 左
        dfs(root.left);
        // 中
        update(root.val);
        // 右
        dfs(root.right);
    }

    void update(int x) {
        // 如果这个数 == 之前那个数
        // 那么次数 + 1
        if (x == num) {
            count++;
        }else {
            // 不相等，那么就开始统计一个数字
            num = x;
            count = 1;
        }
        if (count == maxCount){
            res.add(num);
        }
        if (count > maxCount){
            maxCount = count;
            res.clear();
            res.add(num);
        }
    }
}