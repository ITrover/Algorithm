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
class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(0);
        ListNode result = p;
        p.next = head;
        while(p != null){
            if (!swap(p)) {
                break;
            }
            p = p.next.next;
        }
        return result.next;
    }

    boolean swap(ListNode node){
        if (node !=null && node.next != null && node.next.next != null){
            // 修改三个指针
            ListNode temp = node.next.next;
            node.next.next = temp.next;
            temp.next = node.next;
            node.next = temp;
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
