package swordToOffer.lowestCommonAncestor.binSearchTree;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 解法1的优化
 * 保证p小于q，减少判断
 * @date 2020/8/24 14:03
 */
class Solution3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 p.val < q.val
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null) {
            // p,q 都在 root 的右子树中
            if (root.val < p.val) {
                // 遍历至右子节点
                root = root.right;
            }
            // p,q 都在 root 的左子树中
            else if (root.val > q.val) {
                // 遍历至左子节点
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}

