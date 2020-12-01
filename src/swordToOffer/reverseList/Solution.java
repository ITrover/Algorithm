package swordToOffer.reverseList;

/**
 * @author itrover
 * 剑指 Offer 24. 反转链表 https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 递归
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

    ListNode head;
    public ListNode reverseList(ListNode head) {
        this.head = null;
        ListNode recur = recur(head);
        if (recur != null){
            recur.next = null;
        }
        return this.head;
    }
    ListNode recur(ListNode head){
        if (head == null){
            return null;
        }
        ListNode pre = recur(head.next);
        if (pre != null){
            pre.next = head;
        }else{
            this.head = head;
        }
        // 返回末尾
        return head;
    }
}
