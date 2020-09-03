package swordToOffer.codec;

import java.util.*;

/**
 * @author itrover
 */
public class Codec {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static final String nullTree = "[]";

    public String serialize(TreeNode root) {
        if (root == null) {
            return nullTree;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        // 二叉树按层遍历
        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node != null) {
                builder.append(node.val + ",");
                deque.add(node.left);
                deque.add(node.right);
            } else {
                builder.append("null,");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals(nullTree)) {
            return null;
        }
        String[] val = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            // 添加左右结点
            TreeNode node = queue.poll();
            if (!val[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(val[i]));
                queue.add(node.left);
            }
            i++;
            if (!val[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(val[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(codec.serialize(root));
    }

}
