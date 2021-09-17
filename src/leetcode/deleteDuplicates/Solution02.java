package leetcode.deleteDuplicates;

/**
 * 82. 删除排序链表中的重复元素 II https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 递归
 */
class Solution02 {
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

    int[] count = new int[201];

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        count[head.val + 100]++;
        ListNode res = deleteDuplicates(head.next);
        if (count[head.val + 100] > 1) {
            return res;
        }
        head.next = res;
        return head;
    }
}
