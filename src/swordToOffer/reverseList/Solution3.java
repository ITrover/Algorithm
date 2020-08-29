package swordToOffer.reverseList;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 *  双指针
 *      时间复杂度o(n)
 *      空间复杂度o(1)
 * @date 2020/8/22 16:49
 */
class Solution3 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = null;
        ListNode listNode = solution3.reverseList(node);
    }
}
