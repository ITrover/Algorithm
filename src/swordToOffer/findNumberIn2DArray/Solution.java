package swordToOffer.findNumberIn2DArray;

/**
 * 二分查找，广度优先搜索
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return isTarget(matrix, 0, 0, target);
    }

    public boolean isTarget(int[][] matrix, int n, int m, int target) {
        if (n >= matrix.length || m >= matrix[0].length) {
            return false;
        }
        if (matrix[n][m] > target) {
            return false;
        }
        if (matrix[n][m] == target){
            return true;
        }
        return isTarget(matrix, n + 1, m, target) || isTarget(matrix, n, m + 1, target);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 5));
    }
}