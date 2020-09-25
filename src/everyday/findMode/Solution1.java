package everyday.findMode;


import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数(https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/)
 * 使用遍历实现前序遍历(Morris Traversal方法)
 * 二叉树的前序遍历
 * 前序遍历访问二叉搜索树，访问的顺序是递增的
 * 相同数字连续出现
 */
class Solution1 {
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
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    // 添加线索
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    // 删除线索
                    pre.right = null;
                    update(cur.val);
                    cur = cur.right;
                }
            }
        }
        int[] mode = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            mode[i] = res.get(i);
        }
        return mode;
    }

    void update(int x) {
        // 如果这个数 == 之前那个数
        // 那么次数 + 1
        if (x == num) {
            count++;
        } else {
            // 不相等，那么就开始统计一个数字
            num = x;
            count = 1;
        }
        if (count == maxCount) {
            res.add(num);
        }
        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(num);
        }
    }
}