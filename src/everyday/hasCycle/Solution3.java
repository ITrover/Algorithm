package everyday.hasCycle;

/**
 * @author itrover
 * 141. 环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 * 取巧
 * 利用链表长度在[0,10^4]
 * 时间复杂度o(1) 常量级别最多10001次循环
 * 空间复杂度o(1)
 */
public class Solution3 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode  p = head;
        int n = 0;
        while (p != null){
            p = p.next;
            n++;
            if (n > 10000){
                return true;
            }
        }
        return false;
    }
}
