package swordToOffer.copyRandomList;


import java.util.HashMap;
import java.util.Map;

/**
 * 使用hashMap来辅助链表的复制
 * 以之前的结点为key
 * 以复制后的结点为value
 * 然后通过循环设置新节点的next和random
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution2 {
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

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;

        while (p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }


}
