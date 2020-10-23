package everyday.isPalindrome;

/**
 * @author itrover
 * 234. 回文链表 https://leetcode-cn.com/problems/palindrome-linked-list/
 * 双指针
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int getListLength(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        // 先获得链表的长度
        int len = getListLength(head);
        int half = len / 2;
        ListNode p = null;
        ListNode q = head;
        ListNode pre;
        // 移动到另一半的中间
        for (int i = 0; i < half; i++) {
            // 调转前一半的方向
            pre = q;
            q = q.next;
            pre.next = p;
            p = pre;
        }
        // 奇数的情况，中间的那个不用比较
        if (len % 2 != 0){
            q = q.next;
        }
        while (p != null && p.val == q.val){
            p = p.next;
            q = q.next;
        }
        return p == null;
    }
}
