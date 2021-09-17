package leetcode.isValidSudoku;


/**
 * 36. 有效的数独 https://leetcode-cn.com/problems/valid-sudoku/
 * 使用数组构造哈希表
 */
class Solution02 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num - '1';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    // 记录数量
                    row[i][n]++;
                    col[j][n]++;
                    box[boxIndex][n]++;
                    // 检查数字对应的数量是否大于1
                    if (row[i][n] > 1 || col[j][n] > 1 || box[boxIndex][n] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
