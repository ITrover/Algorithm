package swordToOffer.copyRandomList;


import jdk.nashorn.internal.ir.CallNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用递归
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Map<Node,Node> map =  new HashMap<Node,Node>();

    public Node copyRandomList(Node head) {
        return copy(head);
    }
    public Node copy(Node node) {
        if (node == null) {
            return null;
        }
        Node res = new Node(node.val);
        // 记录结点，为了以后设置random
        // 旧结点与新结点，一一对应
        map.put(node, res);
        res.next = copy(node.next);
        // 设置random
        if (node.random != null) {
            // 找到以前random 对应的新结点
            res.random = map.get(node.random);
        } else {
            res.random = null;
        }
        return res;
    }
}
