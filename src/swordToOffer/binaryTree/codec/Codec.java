package swordToOffer.binaryTree.codec;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Codec {
    public class TreeNode {
        int val;
        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "[null]";
        }
        ArrayList<Integer> list = new ArrayList<>();
        return null;
    }

    public TreeNode deserialize(String data) {
        return null;
    }
}
