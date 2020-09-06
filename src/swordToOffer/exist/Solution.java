package swordToOffer.exist;

import java.util.Arrays;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/9/6 20:50
 * @description 剑指 Offer 12. 矩阵中的路径
 * DFS 回溯
 */
public class Solution {
    String word;
    boolean[][] used;

    /**
     * 将used矩阵全部设置为false
     */
    void refresh() {
        for (int i = 0; i < used.length; i++) {
            Arrays.fill(used[i], false);
        }
    }

    /**
     * 设置used矩阵某一个位置的值
     * @param m
     * @param n
     * @param hasUse
     */
    void setUsed(int m, int n, boolean hasUse) {
        if (m >= 0 && n >= 0 && m < used.length && n < used[0].length) {
            used[m][n] = hasUse;
        }
    }

    public boolean exist(char[][] board, String word) {
        this.word = word;
        used = new boolean[board.length][board[0].length];
        refresh();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 选择不同的起始位置
                if (exist(board, i, j, 0)) {
                    return true;
                }
                // 刷新是否使用过
                // refresh();
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int m, int n, int i) {
        // 前面的字符都已经匹配上
        if (i == word.length()) {
            return true;
        }
        // 到底了，但是还没有全部匹配完
        if (m < 0 || n < 0 || m == board.length || n == board[0].length) {
            return false;
        }
        // 如果该空格进入过，那么路径不对
        // 如果没有匹配上，该路径也不对
        if (used[m][n] || board[m][n] != word.charAt(i)) {
            return false;
        }
        // 标记空格使用过
        used[m][n] = true;
        // 对了，继续深入，上下左右
        // 成功了直接返回
        if (exist(board, m + 1, n, i + 1) ||
                exist(board, m - 1, n, i + 1) ||
                exist(board, m, n - 1, i + 1) ||
                exist(board, m, n + 1, i + 1)){
            return true;
        }
        // 回溯，失败了要还原
        // setUsed(m,n,false);
        used[m][n] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'}
        };
        System.out.println(solution.exist(board, "aaaaaaaaaaaa"));
    }
}
