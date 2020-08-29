package swordToOffer.getKthFromEnd;

import java.util.ArrayList;

/**
 * 双指针
 *  时间复杂度 o(n)
 *  空间复杂度 o(1)
 */
class Solution3 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        // 将cur移到k次，也就比pre提前k
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null){
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }
}