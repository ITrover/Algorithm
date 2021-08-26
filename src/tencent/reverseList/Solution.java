package tencent.reverseList;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2021/8/23 20:03
 * 反转链表的n,m个结点
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    ListNode reverse(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode p = head;
        for (int i = 0; i < m - 1; i++) {
            if (p == null) {
                return head;
            }
            p = p.next;
        }
        ListNode last = p;
        ListNode pre = p;
        ListNode cur = pre.next;
        int i = 0;
        // m,n的反转
        int k = m == 0 ? n - m : n - m + 1;
        while (i < k) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            i++;
        }
        if (m == 0) {
            head = pre;
            last.next = cur;
        } else {
            last.next.next = cur;
            last.next = pre;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode p = node;
        for (int i = 1; i < 10; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        Solution solution = new Solution();
        node = solution.reverse(node, 1, 1);
        p = node;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }


}
