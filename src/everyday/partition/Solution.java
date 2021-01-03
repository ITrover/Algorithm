package everyday.partition;

/**
 * @author itrover
 * 86. 分隔链表 https://leetcode-cn.com/problems/partition-list/
 * 双指针
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
        ListNode big = nHead;
        ListNode small = nHead;
        while (big != null && big.next != null) {
            // 如果小于了x，则将该结点移动到小指针的后面
            if (big.next.val < x) {
                // 如果相等，则一起跳过
                if (big == small){
                    big = big.next;
                }else{
                    ListNode q = big.next;
                    // 跳过该node
                    big.next = big.next.next;
                    // 添加到small后面
                    q.next = small.next;
                    small.next = q;
                }
                small = small.next;
            }else{
                big = big.next;
            }
        }
        return nHead.next;
    }
}
