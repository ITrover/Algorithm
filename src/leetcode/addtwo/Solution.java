package leetcode.addtwo;//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * 时间复杂度 o(n)
 * 空间
 * 解法
 * 一个结果链表
 * 从链表开头，遍历
 * 用一个变量保存进位值。
 * 两数（val1 ,val2） 和 进位值相加，余10后，添加到结果数组。除10后得到进位值。
 *
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(-1);
            ListNode p = result;
            int col = 0;
            while (l1 != null || l2 != null) {
                int val1 = l1 == null ? 0 : l1.val;
                int val2 = l2 == null ? 0 : l2.val;
                p.next = new ListNode((val1 + val2 + col) % 10);
                p = p.next;
                col = (val1 + val2 + col) / 10;

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            p.next = col == 1 ? new ListNode(1) : null;
            result = result.next;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
