package swordToOffer.translateNum;

/**
 * 动态规划
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 */
class Solution {
    public int translateNum(int num) {
        // 初始化
        int a = 1, b = 1;
        String s = String.valueOf(num);
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            // 状态转移
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

}
