package everyday.searchMatrix.two;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2021/10/25 23:59
 * 240. 搜索二维矩阵 II https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
class Solution02 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            // 从左下角开始搜索
            // 当前值大于或小于target只可能往一个方向继续搜索
            // 当前大于target往上继续搜索
            // 当前小于target往右继续搜索
            // 当然也可以从右上开始搜索
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
