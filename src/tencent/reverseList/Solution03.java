package tencent.reverseList;


/**
 * @author MaYunHao
 * @version 1.0
 * @date 2021/8/23 20:03
 * 反转链表的n,m个结点，使用伪头
 */
public class Solution03 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    ListNode reverse(ListNode head, int m, int n) {
        ListNode node = new ListNode(-1);
        node.next = head;
        head = node;
        ListNode p = head;
        for (int i = 0; i < m; i++) {
            if (p == null) {
                return head;
            }
            p = p.next;
        }
        // reverse
        // m,n之间一定有结点
        ListNode pre = p.next;
        ListNode cur = pre.next;
        int i = 0;
        while (i < n - m) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
            i++;
        }
        p.next.next = cur;
        p.next = pre;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode p = node;
        for (int i = 1; i < 10; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        Solution03 solution = new Solution03();
        node = solution.reverse(node, 0, 4);
        p = node;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }


}
