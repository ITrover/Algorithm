package swordToOffer.reversePrint;

import java.util.ArrayList;

/**
 * 遍历，赋值法
 * 时间复杂度 o(n)
 * 空间复杂度 o(n)
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[list.size() - i - 1] = list.get(i);
        }
        return res;
    }

}