package swordToOffer.copyRandomList;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/14 19:02
 */

/**
 * 将
 *
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution3 {
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
        copy(head);
        setRandom(head);
        return getClone(head);
    }

    /**
     * 复制每一个结点，并拼接到结点后面
     * @param head
     * @return
     */
    public Node copy(Node head){
        Node pNode = head;
        while (pNode != null){
            // 复制出结点node
            Node noceClone = new Node(pNode.val);
            // 复制结点后面指向下一个结点
            noceClone.next = pNode.next;
            noceClone.random = null;

            pNode.next =noceClone;
            // 下一个结点
            pNode = noceClone.next;
        }
        return head;
    }

    /**
     * 是复制的的random
     * @param head
     * @return
     */
    public Node setRandom(Node head){
        Node pNode = head;
        while (pNode != null){
            // 得到该结点的复制结点
            Node pNodeCopy = pNode.next;
            if (pNode.random != null && pNode.next != null){
                // 设置复制结点的random
                pNodeCopy.random = pNode.random.next;
            }
            pNode = pNodeCopy.next;
        }
        return head;
    }

    /**
     * 把Clone结点给截出来
     * @param head
     * @return
     */
    public Node getClone(Node head){
//        if (head == null){
//            return null;
//        }
//        // 复制的结点
//        Node pHead = head.next;
//        Node pClone = pHead;
//        // 原来的结点
        // 这里为什么是错的
//        Node pNode = pClone.next;
//        while (pNode != null){
//            pClone.next = pNode.next;
//            pClone = pClone.next;
//            pNode.next = pClone.next;
//            pNode = pNode.next;
//        }
//        return pHead;
        Node pNode = head;
        Node pCloneHead = null;
        Node pClone = null;
        if (pNode != null){
            pCloneHead = pClone = pNode.next;
            pNode.next = pCloneHead.next;
            pNode = pNode.next;
        }
        while (pNode != null){
            pClone.next = pNode.next;
            pClone = pClone.next;
            pNode.next = pClone.next;
            pNode = pNode.next;
        }
        return pCloneHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        head.random = node;
        node.next = null;
        node.random = node;
        Solution3 solution3 = new Solution3();
        solution3.copyRandomList(head);
    }
}
