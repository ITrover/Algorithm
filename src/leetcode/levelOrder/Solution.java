package leetcode.levelOrder;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return lists;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            // 把之前stack里面的东西全部取出来
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                    // 把该节点的值放到结果集中
                list.add(node.val);
                    if (node.left != null){
                        queue.add(node.left);
                    }
                    if (node.right != null){
                        queue.add(node.right);
                    }
            }
            lists.add(list);
        }
        return lists;
    }

}
