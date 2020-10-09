package everyday.hasCycle;

import java.util.HashSet;

/**
 * @author itrover
 * 141. 环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 * HashSet
 * 时间复杂度o(n)
 * 空间复杂度o(n)
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

    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        HashSet<ListNode> set = new HashSet<>();
        while (p != null){
            set.add(p);
            if (set.contains(p.next)){
                return true;
            }
            p = p.next;
        }
        return false;
    }
}
