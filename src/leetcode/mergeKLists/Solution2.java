package leetcode.mergeKLists;
//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


//leetcode submit region begin(Prohibit modification and deletion)



/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
   public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 两两合并
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result =  mergeTwoLists(result,lists[i]);
        }
        return result;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 特别简单
        // 链表操作
        // 时间复杂度 o(n)
        // 还可以使用递归来做
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
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
        if (p1 != null){
            h1.next = p1;
        }
        if (p2 != null){
            h1.next = p2;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
