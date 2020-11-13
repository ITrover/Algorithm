package everyday.oddEvenList;

/**
 * @author itrover
 * 328. 奇偶链表 https://leetcode-cn.com/problems/odd-even-linked-list/
 * 链表操作
 * 双指针
 */
class Solution {

    public static class ListNode {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = head;
        ListNode p = head.next;
        while (p != null && p.next != null){
            ListNode next = pre.next;
            pre.next = p.next;
            p.next = p.next.next;
            pre = pre.next;
            pre.next = next;
            p = p.next;

        }
        return head;
    }
}
