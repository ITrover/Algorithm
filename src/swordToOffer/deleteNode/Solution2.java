package swordToOffer.deleteNode;


/**
 * 递归法
 *  时间复杂度o(n)
 *  空间复杂度o(1)
 */
class Solution2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = deleteNode(head.next, val);
        return head.val == val ? head.next : head;
    }
}