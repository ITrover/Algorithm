package leetcode.isValidSudoku;

import java.util.HashMap;

/**
 * 36. 有效的数独 https://leetcode-cn.com/problems/valid-sudoku/
 * 哈希表
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] col = new HashMap[9];
        HashMap<Integer, Integer>[] row = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            col[i] = new HashMap<Integer, Integer>();
            row[i] = new HashMap<Integer, Integer>();
            box[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // 记录数量
                    row[i].put(n, row[i].getOrDefault(n, 0) + 1);
                    col[j].put(n, col[j].getOrDefault(n, 0) + 1);
                    box[box_index].put(n, box[box_index].getOrDefault(n, 0) + 1);

                    // 检查数字对应的数量是否大于1
                    if (row[i].get(n) > 1 || col[j].get(n) > 1 || box[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
