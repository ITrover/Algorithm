package leetcode.middleNode;

/**
 * @author itrover
 * 876. 链表的中间结点 https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 快慢指针
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

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
