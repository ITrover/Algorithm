package utils;



/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/25 10:34
 * @description
 */
public class TreeUtils {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 将数组按照层次遍历生成二叉树
     * @param nodes
     * @return
     */
    public static TreeNode arraysToTree(Integer[] nodes){
        return arraysToTree(nodes,0);
    }

    private static TreeNode arraysToTree(Integer[] nodes, int index){
        if (nodes.length < index || nodes[index] == null) {
            return null;
        }
        TreeNode node = new TreeNode(nodes[index]);
        node.left = arraysToTree(nodes,index + 1);
        node.right = arraysToTree(nodes,index + 2);
        return node;
    }
}
