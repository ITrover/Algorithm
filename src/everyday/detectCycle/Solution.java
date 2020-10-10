package everyday.detectCycle;

import java.util.HashSet;

/**
 * @author itrover
 * 142. 环形链表 II https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @see everyday.hasCycle.Solution
 * 哈希表
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null){
            if (set.contains(p)){
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }
}
