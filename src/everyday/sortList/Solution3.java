package everyday.sortList;

/**
 * @author itrover
 * 148. 排序链表 https://leetcode-cn.com/problems/sort-list/
 * 自低向上
 */
class Solution3 {

    public static class ListNode {
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        // subLength为每次归并的长度
        for (int subLength = 1; ; subLength = subLength << 1) {
            // 切割合并的次数
            int mergeCnt = 0;
            // 开始归并的地方
            ListNode start = fakeHead.next;
            // 下次归并开始的地方
            ListNode next = new ListNode(0);
            // 拼接的地方
            ListNode pre = fakeHead;
            // 一直循环到不能切割合并
            while (start != null) {
                ListNode right = cut2(next, start, subLength);
                pre = merge(pre, start, right);
                start = next.next;
                mergeCnt++;
            }
            // 只合并了一次，可以退出了
            if (mergeCnt <= 1) {
                break;
            }
        }
        return fakeHead.next;
    }

    /**
     * 切割链表
     *
     * @param next 用于返回下次开始的地方
     * @param head 切割开始的地方
     * @param len  切割长度
     * @return 返回后面一段
     */
    ListNode cut(ListNode next, ListNode head, int len) {
        next.next = null;
        if (head == null || head.next == null) {
            return null;
        }
        int cnt = 1;
        ListNode slow = head;
        while (slow != null && cnt < len) {
            slow = slow.next;
            cnt++;
        }
        if (slow != null){
            // 后面一段
            ListNode res = slow.next;
            ListNode fast = slow.next;
            // 切割前面一段
            slow.next = null;
            cnt = 1;
            while (fast != null && cnt < len) {
                fast = fast.next;
                cnt++;
            }
            if (fast != null) {
                // 下一次开始的起点
                next.next = fast.next;
                // 切断后面一段
                fast.next = null;
            }
            return res;
        }
        return null;
    }

    ListNode cut2(ListNode next, ListNode head, int len) {
        next.next = null;
        if (head == null || head.next == null) {
            return null;
        }
        int cnt = 1;
        ListNode slow = head;
        ListNode fast = head.next;
        while (cnt < len) {
            slow = slow != null ? slow.next : null;
            fast = fast != null && fast.next != null ? fast.next.next : null;
            cnt++;
        }
        ListNode res = null;
        if (slow != null){
            res = slow.next;
            slow.next = null;
        }
        if (fast != null){
            next.next = fast.next;
            fast.next = null;
        }
        return res;
    }


    /**
     * @param pre   表头
     * @param left  左边链表的起点
     * @param right 右边链表的起点
     * @return 返回表尾，即下一次拼接的地方
     */
    ListNode merge(ListNode pre, ListNode left, ListNode right) {
        ListNode p = pre;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left == null ? right : left;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(0);
        solution3.sortList(head);
    }
}

