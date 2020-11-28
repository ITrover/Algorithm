package swordToOffer.getIntersectionNode;


/**
 * @author itrover
 * 剑指 Offer 52. 两个链表的第一个公共节点 https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 双指针
 * 两个链表长度分别为L1+C、L2+C， C为公共部分的长度，
 * 第一个人走了L1+C步后，回到第二个人起点走L2步；第2个人走了L2+C步后，回到第一个人起点走L1步。
 * 他们都走了L1+L2+C步，如果有公共部分则相遇，否则走到对方的尽头（null）
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
