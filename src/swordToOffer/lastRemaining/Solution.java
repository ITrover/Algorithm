package swordToOffer.lastRemaining;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 剑指 Offer 62. 圆圈中最后剩下的数字
 * 方法一：使用环形链表来模拟
 * 时间复杂度：o(m*n)
 * 空间复杂度：o(n)
 * 超出时间限制
 * 方法二：使用推导出的规律。
 * 时间复杂度：o(n)
 * 空间复杂度：o(1)
 * @date 2020/8/10 21:41
 */
public class Solution {

    public int lastRemaining(int n, int m) {

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            for (int j = 1; j < m; j++) {
                i++;
                if (i >= list.size()) {
                    i = 0;
                }
            }
            list.remove(i);
            if (i == list.size()){
                i = 0;
            }
        }
        return list.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(5, 3));
    }
}
