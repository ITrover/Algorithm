package swordToOffer.addTwoNumbers;


import java.util.Stack;

/**
 * @author itrover
 * 剑指 Offer II 025. 链表中的两数相加 https://leetcode-cn.com/problems/lMSNwu/
 * 栈
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> l1Node = new Stack<>();
        Stack<ListNode> l2Node = new Stack<>();
        moveNodeToStack(l1, l1Node);
        moveNodeToStack(l2, l2Node);
        Stack<ListNode> pNode;
        ListNode r;
        if (l1Node.size() > l2Node.size()) {
            pNode = l1Node;
            r = l1;
            l1Node = l2Node;
        } else {
            r = l2;
            pNode = l2Node;
        }
        int c = 0;
        // 两链表相加
        while (!l1Node.isEmpty()) {
            ListNode node1 = pNode.pop();
            ListNode node2 = l1Node.pop();
            int sum = node2.val + node1.val + c;
            node1.val = (sum) % 10;
            c = sum / 10;
        }
        // 处理最后的进位
        while (c != 0) {
            if (!pNode.isEmpty()) {
                ListNode node = pNode.pop();
                int sum = node.val + c;
                node.val = sum % 10;
                c = sum / 10;
            } else {
                ListNode node = new ListNode(c);
                node.next = r;
                r = node;
                c = 0;
            }
        }
        return r;
    }

    private void moveNodeToStack(ListNode l1, Stack<ListNode> l1Node) {
        ListNode p = l1;
        while (p != null) {
            l1Node.push(p);
            p = p.next;
        }
    }

}
