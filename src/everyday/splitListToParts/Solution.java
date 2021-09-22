package everyday.splitListToParts;

/**
 * @author itrover
 * 725. 分隔链表 https://leetcode-cn.com/problems/split-linked-list-in-parts/
 * 链表操作
 */
class Solution {
    public class ListNode {
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

    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = getLength(head);
        int n = length / k;
        int m = length % k;
        ListNode[] res = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            // 长度
            int size = n + (i < m ? 1 : 0);
            // 移动到第n个
            for (int j = 1; j < size; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }

    int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }

}
