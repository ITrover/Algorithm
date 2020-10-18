package leetcode.removeNthFromEnd;

/**
 * 19. 删除链表的倒数第N个节点 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 递归
 * 双指针解法 {@link Solution}
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
public class Solution2 {
    private class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null){
            return head;
        }
        int t = dfs(head,n);
        if (n >= t){
            return head.next;
        }
        return head;
    }

    int dfs(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        // 通过返回值， 获得当前位于第几层
        int t = dfs(head.next, n);
        if (t == n) {
            // 当前是倒数第n + 1层
            // 删除第n层
            head.next = head.next.next;
        }
        return t + 1;
    }

}
