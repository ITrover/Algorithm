package swordToOffer.maxSlidingWindow.improve;

import java.util.*;

/**
 * @author itrover
 * DD-2020006. 简单游戏 https://leetcode-cn.com/problems/1zD30O/
 * 滑动窗口
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.print(simpleGame(n, m, arr));
        }
    }

    private static int simpleGame(int n, int m, int[] arr) {
        int sum = 0;
        // 构造一个长度为 m - 1 的窗口
        for (int i = 1; i < m; i++) {
            sum += arr[i];
        }
        int ans = sum + arr[0];
        int min = arr[0];
        int l = 1;
        int r = m;
        // 贪心算法
        while (r < n) {
            // 如果当前滑动窗口的最右侧小于0，则保留，否则舍弃
            min = Math.min(min, 0) + arr[l];
            // 滑动窗口右移
            sum += arr[r++] - arr[l++];
            // 更新最小值
            ans = Math.min(ans, sum + min);
        }
        return ans;
    }
}
