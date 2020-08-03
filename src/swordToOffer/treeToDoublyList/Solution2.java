package swordToOffer.treeToDoublyList;

/**
 * 树的中序遍历
 * 通过中序遍历的特点，访问顺序刚好是由小到大
 */
class Solution2 {

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

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node root){
        if (root == null) {
            return ;
        }
        // 首先访问的是左子树
        treeToDoublyList(root.left);
        if (pre != null){
            pre.right = root;
        }else{
            head = root;
        }
        root.left = pre;
        pre = root;
        // 最后访问的是右子树
        treeToDoublyList(root.right);
    }



    public static void main(String[] args) {
        Node node = new Node(4);
        Node left = new Node(2);
        Node right = new Node(5);
        left.left = new Node(1, null, null);
        left.right = new Node(3, null, null);
        node.left = left;
        node.right = right;
        Solution2 solution = new Solution2();
        solution.treeToDoublyList(node);
    }

}
