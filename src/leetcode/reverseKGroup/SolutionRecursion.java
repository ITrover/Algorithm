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

import com.sun.xml.internal.txw2.output.CharacterEscapeHandler;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class SolutionRecursion {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 反转链表
     *
     * @param head 原始链表
     * @param k    需要反转的个数
     * @return 头节点
     */
    public ListNode reverse(ListNode head, int k) {
        ListNode p = head;
        ListNode cur = head;
        ListNode pre = null;
        // 计算长度 , 如果长度小于k则不需要反转
        // 可优化
        for (int i = 0; i < k; i++) {
            if (p != null){
                p = p.next;
            }else{
                return head;
            }
        }
        p = head;
        //反转k个节点
        for (int i = 0; i < k ; i++) {
            if (p != null){
                cur = p;
                p = p.next;
                cur.next = pre;
                pre = cur;
            }else{
                // 当传入的节点数小于k时，直接返回原来的链表
                // 还原然后返回
                return head;
            }
        }
        // 将本次反转后的最后一个节点的next指向下一个反转的开头
        head.next = reverse(p,k);
        return cur;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // 使用递归来做
        head = reverse(head,k);
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode p = node;
        for (int i = 2; i < 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        SolutionRecursion recursion = new SolutionRecursion();
        recursion.reverse(node,2);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
