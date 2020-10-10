package everyday.detectCycle;

import java.util.HashSet;
import java.util.List;

/**
 * @author itrover
 * 利用链表长度最大为10000
 */
public class Solution2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        while (p != null){
            int n = 0;
            ListNode q = p;
            while (q != null){
                n++;
                q = q.next;
                if (n > 10000){
                    break;
                }
                if (q == p){
                    return p;
                }
            }
            p = p.next;
        }
        return null;
    }
}
