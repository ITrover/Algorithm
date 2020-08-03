package swordToOffer.treeToDoublyList;

/**
 * 使用递归
 */
class Solution {

    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        Node end = treeToDoublyList(root, false);
        Node head = end;
        while(head.left != null){
            head = head.left;
        }
        head.left = end;
        end.right = head;
        return head;
    }

    public Node treeToDoublyList(Node root, boolean isRight){
        if (root == null){
            return null;
        }
        // 中间结点
        Node res = root;

        if (root.left != null){
            // 左边不为空的情况
            Node back = treeToDoublyList(root.left, false);
            back.right = root;
            root.left = back;
            // 如果是右边的树，那么返回最左边的结点
            if (isRight){
                while(back.left != null){
                    back = back.left;
                }
                res = back;
            }
        }

        if (root.right != null){
            Node back = treeToDoublyList(root.right, true);
            back.left = root;
            root.right = back;
            // 如果是左树，那么就要返回最右边的树
            if (!isRight){
                while(back.right != null){
                    back = back.right;
                }
                res = back;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node node = new Node(4);
        Node left = new Node(2);
        Node right = new Node(5);
        left.left = new Node(1,null,null);
        left.right = new Node(3,null,null);
        node.left = left;
        node.right = right;
        Solution solution = new Solution();
        solution.treeToDoublyList(node);
    }

}
