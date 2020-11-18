package everyday.oddEvenList;

/**
 * @author itrover
 * 328. 奇偶链表 https://leetcode-cn.com/problems/odd-even-linked-list/
 * 链表操作
 * 同{@link Solution}
 * 只是结点变换的方式不同
 */
class Solution3 {

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
        if (head == null || head.next == null){
            return head;
        }
        // 指向奇链表的最后
        ListNode pre = head;
        // 指向偶链表的最后
        ListNode p = head.next;
        while (p != null && p.next != null){
            // 剪断
            ListNode t = p.next;
            p.next  = t.next;
            p = p.next;
            // 插入
            t.next = pre.next;
            pre.next = t;
            pre = pre.next;
        }
        return head;
    }
}
