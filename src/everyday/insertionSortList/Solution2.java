package everyday.insertionSortList;

/**
 * @author itrover
 * 147. 对链表进行插入排序 https://leetcode-cn.com/problems/insertion-sort-list/
 * 不使用伪头
 */
class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            // 优化
            // 不插入的条件
            if (cur.val <= cur.next.val) {
                cur = cur.next;
                continue;
            }
            // 一定会插入
            ListNode theNode = cur.next;
            ListNode pre = null;
            ListNode p = head;
            while (p.val < theNode.val) {
                pre = p;
                p = p.next;
            }
            // 删除代插入结点
            cur.next = cur.next.next;
            // 插入到头部
            if (p == head) {
                theNode.next = head;
                head = theNode;
            } else {
                // 插入到中间
                theNode.next = pre.next;
                pre.next = theNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        solution.insertionSortList(root);
    }
}
