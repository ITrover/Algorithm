package tencent.rotateRight;

/**
 * 61. 旋转链表 https://leetcode-cn.com/problems/rotate-list/
 * 链表操作
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int getListLength(ListNode head) {
        ListNode p = head;
        int res = 0;
        while (p != null) {
            p = p.next;
            res++;
        }
        return res;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = getListLength(head);
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode p = head;
        // 移动到倒数第k+1个结点
        for (int i = 0; i < len - k - 1; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        p.next = null;
        p = q;
        while (q != null && q.next != null) {
            q = q.next;
        }
        // 拼接链表
        q.next = head;
        return p;
    }
}
