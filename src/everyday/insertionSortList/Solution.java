package everyday.insertionSortList;

/**
 * @author itrover
 * 147. 对链表进行插入排序 https://leetcode-cn.com/problems/insertion-sort-list/
 * 使用伪头
 * 对于链表操作，有两点意见
 * 1. 尽量使用伪头，让头部的操作和其他结点的操作方式一致
 * 2. 每个阶段用当前结点操作它的下一个结点，因为对结点的修改，都是建立在它前面节点的基础上，
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            // 这一步是性能提升的关键
            // 先和已经排序的最后一个对比，如果比他大则不移动
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
