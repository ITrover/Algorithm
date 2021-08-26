package tencent.reverseList;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2021/8/23 20:03
 */
public class Solution02 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * n 后的结点
     */
    private ListNode last;
    /**
     * 反转后的头
     */
    private ListNode reverseHead;
    /**
     * m前的结点
     */
    private ListNode headLast;


    ListNode reverse(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode reverseLast = dfs(head, m, n, 0);
        reverseLast.next = last;
        // 如果m == 0， 那么反转后的头就是头
        if (headLast == null) {
            head = reverseHead;
        } else {
            headLast.next = reverseHead;
        }
        return head;
    }

    ListNode dfs(ListNode head, int m, int n, int index) {
        if (head == null) {
            return null;
        }
        // 大于n的结点不反转
        if (index == n) {
            // n后的结点
            last = head.next;
            // 反转后的头
            reverseHead = head;
            return head;
        }
        // index < m的节点不反转
        if (index < m) {
            // 往下递归不做操作
            headLast = head;
            return dfs(head.next, m, n, index + 1);
        }
        // m,n的结点
        ListNode pre = dfs(head.next, m, n, index  + 1);
        pre.next = head;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode p = node;
        for (int i = 1; i < 10; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        Solution02 solution = new Solution02();
        node = solution.reverse(node, 4, 9);
        p = node;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }


}
