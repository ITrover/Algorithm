package everyday.sortList;

/**
 * @author itrover
 * 148. 排序链表 https://leetcode-cn.com/problems/sort-list/
 * 使用伪头、链表操作思路要清晰，最好要画图
 * 归并排序
 * 自顶向下
 */
class Solution {
    public class ListNode {
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 使用快慢指针将链表分成两部分
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 下一部分
        ListNode tmp = slow.next;
        //  切割
        slow.next = null;
        // 两部分分别进行归并排序
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 设置伪头
        ListNode h = new ListNode(0);
        ListNode res = h;
        // 合并两个排序的链表
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
