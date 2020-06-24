package leetcode.swapPairs;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        // 使用递归
        // 有三个问题
        // 终止条件是什么 （传入的链表小于2）
        // 子问题（调用单元）什么 （传入节点与下一个节点交换）
        // 返回什么 （返回交换后的头节点）

        //递归终止条件
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        //交换两次
        // 第一个的next指向第二个的next
        head.next = swapPairs(next.next);
        // 第二个的next指向第一个
        next.next = head;
        // 返回相邻两个节点的头节点，也就是上一个递归的next
        return next;
    }

}
