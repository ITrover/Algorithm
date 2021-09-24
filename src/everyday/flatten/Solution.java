package everyday.flatten;

/**
 * @author itrover
 * 430. 扁平化多级双向链表 https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * 链表操作
 */
class Solution {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node p = head;
        while (p != null) {
            if (p.child != null) {
                Node next = p.next;
                p.next = p.child;
                p.child.prev = p;
                Node q = p.child;
                p.child = null;
                while (q.next != null) {
                    q = q.next;
                }
                if (next != null) {
                    q.next = next;
                    next.prev = q;
                }
            }
            p = p.next;
        }
        return head;
    }
}
