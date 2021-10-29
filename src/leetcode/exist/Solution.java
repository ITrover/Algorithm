package leetcode.exist;

/**
 * @author itrover
 * 79. 单词搜索 https://leetcode-cn.com/problems/word-search/
 * 回溯
 */
class Solution {

    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int i, int j, char[][] board, String word, int index) {
        if (word.length() == index) {
            return true;
        }
        if (i == board.length || j == board[0].length
                || i < 0 || j < 0
                || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(i + 1, j, board, word, index + 1)) {
            return true;
        }
        if (dfs(i, j + 1, board, word, index + 1)) {
            return true;
        }
        if (dfs(i - 1, j, board, word, index + 1)) {
            return true;
        }
        if (dfs(i, j - 1, board, word, index + 1)) {
            return true;
        }
        // 都没搜索到
        visited[i][j] = false;
        return false;
    }
}
