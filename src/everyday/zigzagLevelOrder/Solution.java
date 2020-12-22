package everyday.zigzagLevelOrder;


import java.util.*;

/**
 * @author itrover
 * 103. 二叉树的锯齿形层序遍历 https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 层次遍历的变种
 * BFS、队列
 * 技巧：队列中的顺序始终是从左到右
 *      通过插入方式修改结果中的顺序
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        // 从左往右
        boolean isOrderLeft = true;
        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                // 通过添加头部/尾部修改顺序
                // 插入尾部就是左到右
                // 插入头部就是右到左
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                // 保持队列中的结点是按照当前层的从左到右放置的
                add(nodeQueue, curNode.left);
                add(nodeQueue, curNode.right);
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }

    private void add(Queue<TreeNode> nodeQueue, TreeNode right) {
        if (right != null) {
            nodeQueue.offer(right);
        }
    }
}
