package everyday.isPalindrome;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/10/23 21:42
 * @description
 * 数学方法
 * 利用会问的特性
 * 分别从前面和后面构造整数
 * 如果是回文，那么一定相等
 * 有局限性
 */
public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        long s1 = 0, s2 = 0, t = 1;
        while (head != null) {
            s1 = s1 * 10 + head.val;
            s2 = s2 + t * head.val;
            t = t * 10;
            head = head.next;
        }
        return s1 == s2;
    }
}
