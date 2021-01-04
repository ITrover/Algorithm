package leetcode.tictactoe;

/**
 * 面试题 16.04. 井字游戏 https://leetcode-cn.com/problems/tic-tac-toe-lcci/
 * 考虑所有情况
 * 时间复杂度o(n^2)
 * TODO: 优化
 */
class Solution {
    public String tictactoe(String[] board) {
        // 1.判断每一行/列，对角线是否被相同的元素占据，是 ? X OR O : 2
        // 2.判断是否有空格，有 ? pending : 无 Draw
        boolean pending = false;
        // 每一列胜负情况
        char[] dp = new char[board[0].length()];
        // 初始化
        for(int i = 0; i < board[0].length(); i++){
            dp[i] = board[0].charAt(i);
            if(board[0].charAt(i) == ' '){
                pending = true;
            }
        }
        char s1 = board[0].charAt(0);
        char s2 = board[0].charAt(board[0].length() - 1);
        for(int i = 1; i < board.length; i++){
            String s = board[i];
            char row = s.charAt(0);
            for(int j = 0; j < s.length(); j++){
                // 更新每一列的情况
                dp[j] = dp[j] == s.charAt(j) ? dp[j] : 'A';
                // 更新每一个行
                row = row == s.charAt(j) ? row : 'A';
                    if(s.charAt(i) == ' '){
                    pending = true;
                }
            }
            // 行满足情况了
            if(row == 'O' || row == 'X'){
                return row + "";
            }
            // 更新对角线
            s1 = s.charAt(i) == s1 ? s1 : 'A';
            s2 = s.charAt(s.length() - i - 1) == s2 ? s2 : 'A';
        }
        // 列的情况
        for (char c : dp) {
            if (c == 'X' || c == 'O') {
                return c + "";
            }
        }
        if(s1 == 'X' || s1 == 'O'){
            return s1 + "";
        }
        if(s2 == 'X' || s2 == 'O'){
            return s2 + "";
        }
        return pending ? "Pending" : "Draw";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tictactoe(new String[]{"OO", " X"}));
    }
}
