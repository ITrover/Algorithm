package swordToOffer.lowestCommonAncestor;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 展开写法
 * @date 2020/8/24 13:38
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        // 当越过叶节点，则直接返回 null；
        //  当 root 等于 p,q ，则直接返回 root；
        if (root == null || root == p || root == q) {
            return root;
        }
        // 递归工作
        // 开启递归左子节点，返回值记为 left；
        // 开启递归右子节点，返回值记为 right；
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q，返回 null；
        if (left == null && right == null) {
            return null;
        }
        // 有两种情况
        // p,q其中一个在右子树
        // p,q都在右子树，那么right指向公共祖先
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // 当 left 和 right 同时不为空 ：
        // 说明 p, q分列在 root 的 异侧 （分别在 左 / 右子树），
        // 因此 root 为最近公共祖先，返回 root；
        return root;
    }
}

