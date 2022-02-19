package everyday.pancakeSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 969. 煎饼排序 https://leetcode-cn.com/problems/pancake-sorting/
 * 排序（类似于选择排序），选择最大值然后交换
 */
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int k = arr.length - 1; k > 0; k--) {
            // 找最大值所在下标
            int index = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= k; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
            }
            if (index != k) {
                // 将最大值交换到前面
                reverse(arr, index);
                // 将最大值交换到后面
                reverse(arr, k);
                res.add(index + 1);
                res.add(k + 1);
            }
        }
        return res;
    }



    private void reverse(int[] arr, int k) {
        int i = 0, j = k;
        while (i < j) {
            // 交换i,j
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pancakeSort(new int[] {3,2,4,1});
    }
}
