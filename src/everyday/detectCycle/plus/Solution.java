package everyday.detectCycle.plus;

import java.util.List;

/**
 * @author itrover
 * 面试题 02.08. 环路检测 https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 * 双指针
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            // 相遇了
            if (slow == fast) {
                while (head != slow) {
                    // 起点到入口的位置s1 == 相遇位置到入口的距离s2
                    // 快慢指针移动距离的关系：2(s1 + s2) = s1 + nx + s2
                    // 有s1 + s2 = nx
                    // s1 = (n - 1)x + n - s2
                    // (n - 1)x表示在环内循环了n-1圈，n - s2表示相遇位置到环入口的位置
                    // 若两个指针分别从起点和s2处移动，则一定能够在起点相遇
                    // 一个指针在环内循环了x圈+n-s2，到达入口，一个在环外走了s1步
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
