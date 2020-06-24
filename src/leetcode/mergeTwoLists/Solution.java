package leetcode.mergeTwoLists;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class ListNode {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 特别简单
        // 链表操作
        // 时间复杂度 o(n)
        // 还可以使用递归来做
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0,null);
        ListNode h1 = head;
        while(p1 != null && p2 != null){
            if (p1.val > p2.val){
                h1.next = p2;
                p2 = p2.next;
            }else{
                h1.next = p1;
                p1 = p1.next;
            }
            h1 = h1.next;
        }

        // 因为是链表，所以剩余节点可以直接拼接。
        if (p1 != null){
            h1.next = p1;
        }
        if (p2 != null){
            h1.next = p2;
        }
//        while (p1 != null){
//            h1.next = p1;
//            p1 = p1.next;
//            h1 = h1.next;
//        }
//        while (p2 != null){
//            h1.next = p2;
//            p2 = p2.next;
//            h1 = h1.next;
//        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
