package tencent.binarySearch;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2021/8/23 20:33
 */
public class Solution {

    /**
     * @param arr    升序数组
     * @param target 目标值
     * @return if exist return index,else return -1
     */
    int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] == target) {
                return mid;
            }
        }
        // 没有找到
        return -1;
    }

    /**
     * 二分查找，返回左边界
     *
     * @param arr
     * @param target
     * @return
     */
    int binarySearchWithLeftBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] == target) {
                right = mid - 1;
            }
        }
        // 没有找到
        if (left >= arr.length || arr[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 二分查找，返回右边界
     *
     * @param arr
     * @param target
     * @return
     */
    int binarySearchWithRightBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] == target) {
                left = mid + 1;
            }
        }
        // 没有找到，两种可能
        // target比arr所有数都小，right = -1
        // arr中不存在target或target > arr的最大的数，那么此时right指向arr中刚好小于target的数
        // 对于这两种可能，left指向的数一定是arr中刚好大于target的数
        // 若存在则返回右边界，不存在则返回刚好大于target的位置，则代码如下
        // return right < 0 || arr[right] != target ? left : right;
        // 若不存在放回-1
        if (right < 0 || arr[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[12];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i;
            System.out.print(arr[i] + " ");
        }
        arr[11] = 20;
        System.out.println(arr[11] + " ");
        System.out.println();
        Solution solution = new Solution();
        System.out.println(solution.binarySearchWithRightBound(arr, 21));
    }

}
