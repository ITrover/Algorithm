package swordToOffer.isSubStructure;

import com.sun.istack.internal.localization.NullLocalizable;
import com.sun.org.apache.bcel.internal.generic.FADD;

/**
 * Solution的易读版
 * 思路都是
 *  1. 寻找根节点
 *  2. 深入比较
 *  如果没找到，但是A又不为空，从左右节点出发，继续1，2操作
 */
class Solution2 {
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
        // 第一步找到A中与B相同值的结点
        boolean result = false;
        if (A != null && B != null) {
            // 找到结点相同的地方后，深入判断结构是否相同
            if (A.val == B.val) {
                result = visit(A, B);
            }

            // 如果result为false，同时A和B都不为空，那么还可能存在子结构
            // 分别从左右出发，去比较、
            // 重新选择根节点
            if (!result) {
                result = visit(A.left, B);
            }
            if (!result) {
                result = visit(A.right, B);
            }

        }
        return result;
    }

    /**
     * 判断是否为子结构
     * 条件 B == null 则B一定是A的子结构
     *      A == null || A.val != B.val 出现不相等了，一定不是子结构
     *
     * @param A
     * @param B
     * @return
     */
    public boolean visit(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) {
            return false;
        }
        // 继续比较他们的左右结点是否相同
        return visit(A.left, B.left) && visit(A.right, B.right);
    }

}
