package everyday.reorderList;

import java.util.List;

/**
 * @author itrover
 * 143. 重排链表 https://leetcode-cn.com/problems/reorder-list/
 * 递归
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution {
    public static class ListNode {
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

    ListNode pre;

    public void reorderList(ListNode head) {
        pre = head;
        recur(head);
    }

    boolean recur(ListNode head){
        if (head == null){
            return true;
        }
        if (recur(head.next)){
            if (pre.next == null || pre.next == head) {
                head.next = null;
                return false;
            }
            head.next = pre.next;
            pre.next = head;
            pre = head.next;
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2,new ListNode(3,new ListNode(4)));
        Solution solution = new Solution();
        solution.reorderList(node);
        System.out.println(node);
    }
}
