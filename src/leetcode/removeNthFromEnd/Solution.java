package leetcode.removeNthFromEnd;//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 双指针，共同向链表末尾移动，两个指针相差n + 1个
        // 在链表前插入一个多余节点，防止删除头节点的情况
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode n1 = tmp;
        ListNode n2 = tmp;
        int i = 0;
        // 还有一种思路
        // 先让一个p移动n个，再一起移动
        while(n2 != null){
            n2 = n2.next;
            if (i < n + 1){
                i ++ ;
            }else{
                // 当 i == n + 1 ， 即n2超过n1 n+1个的时候，移动n1，保持n2始终在n1前n+1个
                n1 = n1.next;
            }
        }
        // 删除一个
        if (n1 != null && n1.next != null){
            n1.next = n1.next.next;
        }
        head = tmp.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
