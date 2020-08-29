package swordToOffer.deleteNode;


/**
 * 链表操作
 *  时间复杂度o(n)
 *  空间复杂度o(1)
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        head = pre;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        // 此时cur有两种情况
        // 1. cur为null，没有找到val
        // 2. cur不为null，当前元素等于val
        if (cur != null) {
            pre.next = cur.next;
        }
        return head.next;
    }
}