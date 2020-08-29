package swordToOffer.reversePrint;

import java.util.ArrayList;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 *  递归法
 *  时间复杂度 o(n)
 *  空间复杂度 o(n)
 * @date 2020/8/21 19:49
 */
class Solution2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    ArrayList<Integer> tmp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    /**
     * 回溯
     * @param head
     */
    void recur(ListNode head){
        if (head == null){
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }
}
