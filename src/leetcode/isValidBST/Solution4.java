package leetcode.isValidBST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author itrover
 * 98. 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 层序遍历迭代法判断上下界 o(n)
 * TODO:使用递归
 */
public class Solution4 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return false;
    }

}
