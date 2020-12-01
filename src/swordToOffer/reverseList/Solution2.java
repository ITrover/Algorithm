package swordToOffer.reverseList;

import java.util.Stack;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 使用栈
 * 时间复杂度 o(n)
 * 空间复杂度 o(n)
 * @date 2020/8/21 20:54
 */
class Solution2 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode res = stack.pop();
        ListNode cur = res;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = null;
        ListNode res = solution2.reverseList(head);
    }
}
