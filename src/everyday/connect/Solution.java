package everyday.connect;


/**
 * @author itrover
 * 117. 填充每个节点的下一个右侧节点指针 II(https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/)
 * 利用next实现层次遍历
 */
class Solution {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        // 遍历
        // 借助上面的next
        Node p = root;
        while (p != null) {
            // 从右到左给下一层赋值
            Node pre = null;
            // 1. 本结点的左边指到右边
            // 2. 上一个结点的最后一个结点指到下一个不为空的结点
            for (Node q = p; q != null; q = q.next) {
                if (q.left != null) {
                    // 1
                    q.left.next = q.right;
                    // 2
                    if (pre != null) {
                        pre.next = q.left;
                    }
                    pre = q.right == null ? q.left : q.right;
                } else if (q.right != null) {
                    // 2
                    if (pre != null) {
                        pre.next = q.right;
                    }
                    pre = q.right;
                }
                // 如果左右都为空，则跳过
            }
            // 开始下一层
            // 如果pre == null，那么一定不存在下一层结点
            if (pre == null){
                break;
            }
            // 找到下一层第一个结点
            for (Node q = p; q != null; q = q.next) {
                if (q.left != null){
                    p = q.left;
                    break;
                }
                if (q.right != null){
                    p = q.right;
                    break;
                }
            }
        }
        return root;
    }
}