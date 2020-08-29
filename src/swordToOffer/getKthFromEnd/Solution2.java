package swordToOffer.getKthFromEnd;

import java.util.ArrayList;

/**
 * 辅助链表
 *  时间复杂度 o(n)
 *  空间复杂度 o(n)
 */
class Solution2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() - k);
    }

}