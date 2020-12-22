package everyday.zigzagLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author itrover
 * 103. 二叉树的锯齿形层序遍历 https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 层次遍历的变种
 * DFS、前/中/后序遍历都可以，他们访问每一层的顺序都是左到右
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null) {
            return;
        }
        //如果res.size() <= level说明下一层的集合还没创建，所以要先创建下一层的集合
        while (res.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }
        //遍历到第几层我们就操作第几层的数据
        List<Integer> list = res.get(level);
        // 这里默认根节点是第0层，偶数层相当于从左往右遍历，
        // 所以要添加到集合的末尾，如果是奇数层相当于从右往左遍历，
        // 要把数据添加到集合的开头
        if (level % 2 == 0) {
            // 偶数层，从左到右，插到后面
            list.add(cur.val);
        } else {
            // 奇数层，从右到左，插入到前面
            list.add(0, cur.val);
        }
        //分别遍历左右两个子节点，到下一层了，所以层数要加1
        travel(cur.left, res, level + 1);
        travel(cur.right, res, level + 1);
    }
}
