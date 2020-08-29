package swordToOffer.reverseLeftWords;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 *          剑指 Offer 58 - II. 左旋转字符串
 * @date 2020/8/10 20:17
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg",2));
    }
}
