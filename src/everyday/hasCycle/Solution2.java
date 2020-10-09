package everyday.hasCycle;

import java.util.HashSet;

/**
 * @author itrover
 * 141. 环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 * Floyd判圈算法
 * 双指针 快慢指针 追击相遇 如果有环最后一定相等
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
public class Solution2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
