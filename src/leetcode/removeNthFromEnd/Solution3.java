package leetcode.removeNthFromEnd;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2022/3/31 14:46
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点 https://leetcode-cn.com/problems/SLwz0R/
 * 快慢指针
 */
public class Solution3 {

    private class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        // fast 先走n步
        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 如何判断是否删除头结点，如果删除头结点，那么fast必为null
        // 删除头结点的情况
        if (fast == null) {
            return head == null ? null : head.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
