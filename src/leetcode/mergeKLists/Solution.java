package leetcode.mergeKLists;
//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
   public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 暴力解法
        // 每次循环寻找当前最小的节点
        // 赋值给result
        // result向前移，最小节点所在列表向前移
        // 时间复杂度 o(lists.length * max(listNode.size))
        if (lists == null || lists.length ==0){
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode p = result;
        ListNode node = null;
        while ((node = findMax(lists)) != null){
            p.next = node;
            p = p.next;
        }
        p.next = null;
        return result.next;
    }
    public ListNode findMax(ListNode[] lists){
       ListNode theMin = new ListNode(Integer.MAX_VALUE);
       int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && theMin.val > lists[i].val){
                theMin = lists[i];
                index = i;
            }
        }
        // 移动
        if (index != -1){
            lists[index] = lists[index].next;
            return theMin;
        }
        // 没有剩余的节点了
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
