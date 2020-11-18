package everyday.oddEvenList;

import java.util.List;

/**
 * @author itrover
 * 328. 奇偶链表 https://leetcode-cn.com/problems/odd-even-linked-list/
 * 链表操作
 * 奇数和偶数分别构成链表
 */
class Solution2 {

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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        ListNode p = even.next;
        boolean b = true;
        while (p != null) {
            if (b) {
                odd.next = p;
                odd = odd.next;
            } else {
                even.next = p;
                even = even.next;
            }
            b = !b;
            p = p.next;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }
}
