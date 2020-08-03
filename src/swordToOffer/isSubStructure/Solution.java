package swordToOffer.isSubStructure;

import com.sun.istack.internal.localization.NullLocalizable;

/**
 * 判断A是否为B的子结构
 * 先找到A中 对应B的根节点
 * 然后同时遍历，如果出现不相等，则不是子结构
 */
class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            left = null;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (visit(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean visit(TreeNode A, TreeNode B) {
            if(B == null) {
                return true;
            }
            if(A == null || A.val != B.val) {
                return false;
            }
            return visit(A.left, B.left) && visit(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        TreeNode B = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.isSubStructure(A, B));
    }

}
