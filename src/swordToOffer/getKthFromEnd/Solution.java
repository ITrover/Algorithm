package swordToOffer.getKthFromEnd;

import java.util.List;

/**
 * 递归法
 *  时间复杂度 o(n)
 *  空间复杂度 o(1)
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    int count = 0;
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode res =  getKthFromEnd(head.next,k);
        count++;
        if (k == count){
            return head;
        }
        return res;
    }

}