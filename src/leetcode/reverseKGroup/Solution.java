package leetcode.reverseKGroup;//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // 可以用栈来做
        // 先把每k个节点压入栈中
        // 然后又返回来
        Stack<ListNode> stack = new Stack();
        if (k == 1) {
            // k == 1不用交换
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode h1 = p;
        p = p.next;
        while (p != null) {
            //暂时的头节点
            // 每k个节点交换一次
            for (int i = 0; i < k; i++) {
                if (p == null) {
                    break;
                }
                stack.push(p);
                p = p.next;
            }
            // 只有当栈中节点的数量等于k时才交换
            if (stack.size() == k) {
                // 以前的头节点指向最后一个
                ListNode node1 = stack.pop();
                h1.next = node1;
                while (!stack.empty()) {
                    ListNode node = stack.pop();
                    node1.next = node;
                    node1 = node;
                }
                node1.next = p;
                h1 = node1;
            }
        }
        return newHead.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
