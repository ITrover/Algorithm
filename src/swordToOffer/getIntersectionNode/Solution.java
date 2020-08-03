package swordToOffer.getIntersectionNode;


/**
 * 双指针
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while(A != B){
            A = A != null ? A.next:headB;
            B = B != null ? B.next:headA;
        }
        return A;
    }
}
