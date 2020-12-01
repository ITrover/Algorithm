package tencent.deleteNode;

/**
 * @author itrover
 * 237. 删除链表中的节点 https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        // 下一个结点的值前移，并跳过下一个结点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
