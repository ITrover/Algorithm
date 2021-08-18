package everyday.searchMatrix;

/**
 * @author itrover
 * 74. 搜索二维矩阵 https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 二分查找
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0){
            return false;
        }
        int[] arr = new int[n];
        int i = 0;
        for(int[] ignored : matrix) {
            arr[i] = matrix[i][0];
            i++;
        }
        int index = bSearch(arr, target);
        if(index == -1 || index == n) {
            return false;
        }
        int col = bSearch(matrix[index], target);
        return matrix[index][col] == target;
    }

    /**
     * 二分查找
     * @return 大于等于target的位置
     */
    int bSearch(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
