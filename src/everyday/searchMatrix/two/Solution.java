package everyday.searchMatrix.two;

/**
 * @author itrover
 * 240. 搜索二维矩阵 II https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 二分查找 每一行
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            int index = binarySearch(ints, target);
            if (index >= 0 && ints[index] == target) {
                return true;
            }
        }
        return false;
    }

    int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] == target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        // 值过小，会溢出
        return right;
    }
}
